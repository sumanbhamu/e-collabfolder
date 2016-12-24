package com.suman.Controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.suman.ecom.dao.CategoryDAO;
import com.suman.ecom.dao.ProductDAO;
import com.suman.ecom.dao.SupplierDAO;
import com.suman.ecom.model.Category;
import com.suman.ecom.model.Product;
import com.suman.ecom.model.Supplier;
import com.suman.ecom.model.User;

@Controller

public class ProductController {

	@Autowired
	ProductDAO productDAO;

	@Autowired
	Product product;
	
	@Autowired
	User user;
	
	@Autowired
	private JavaMailSender mailSender;


	@Autowired
	CategoryDAO categoryDAO;
	@Autowired
	SupplierDAO supplierDAO;

	@Autowired
	Category category;
	@Autowired
	Supplier supplier;

	@RequestMapping("/viewproducts")
	public String ShowViewproducts() {
		return "viewproducts";
	}

	@RequestMapping(value = "/viewdetails")
	public ModelAndView showViewDetails(@RequestParam("id") String id, Model model) {
		// RequestParam is used to get values in string format

		System.out.println("viewproduct paaaaaage");
		System.out.println("Id:" + id);

		// converting string to int
		int i = Integer.parseInt(id);
		model.addAttribute("productlist", productDAO.list());

		/* get product by id */
		Product product1 = productDAO.get(i);
		return new ModelAndView("viewdetails", "product", product1);

	}

	@RequestMapping("/adminviewproducts")
	public String showAdminViewproducts() {
		return "adminviewproducts";
	}

	@RequestMapping(value = "/deleteproduct&{id}")
	public ModelAndView showDeleteProd(@PathVariable("id") String id, Model model) throws Exception {

		int i = Integer.parseInt(id);

		product = productDAO.get(i);

		System.out.println("product deleteeeee");

		ModelAndView mv = new ModelAndView("adminviewproducts");

		productDAO.delete(product);
		mv.addObject("adminviewproducts", 0);

		System.out.println("delete Id:" + id);

		return mv;

	}

	@RequestMapping("/addproduct")
	public ModelAndView ShowAddProduct(Model model) {
		System.out.println("in product");
		ModelAndView mv = new ModelAndView("addproduct");

		/* to get list of categories , supplier id's */
		model.addAttribute("productList", productDAO.list());
		model.addAttribute("categoryList", categoryDAO.list());
		model.addAttribute("supplierList", supplierDAO.list());

		System.out.println("product adddinjnsj list..."+productDAO.list());
		return mv;
	}

	// Creates empty obj and takes values frm user

	@ModelAttribute
	public Product returnObject() {
		return new Product();

	}

	@RequestMapping(value = "/addprod", method = RequestMethod.POST)
	public String ShowAddProduct(@Valid @ModelAttribute("product") Product prod,
			Model model, BindingResult result,
			HttpServletRequest request) throws IOException {
		System.out.println(prod.getProd_name());
		System.out.println("image uploaded");
		System.out.println("myproduct controller called");
		MultipartFile image = prod.getImg();
		Path path;// belong to nio package
		path = Paths.get("C:/Users/user.main/git/e-collabfolder/frontend1/src/main/webapp/resources/images/" + prod.getProd_name() + ".jpg");
		System.out.println("Path=" + path);
		System.out.println("File name" + prod.getImg().getOriginalFilename());
		if (image != null && !image.isEmpty()) {
			try {
				image.transferTo(new File(path.toString()));
				System.out.println("Image Saved in:" + path.toString());
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("Image not saved");

			}
		}

		if (prod.getProd_id() == 0) {
			//new product
		productDAO.savOrUpdate(prod);}
		else{
			productDAO.savOrUpdate(prod);
			return "addproduct";
		}

		HttpSession session=request.getSession(false);
		String email1=(String)session.getAttribute("email");
		
		String usernaam=(String)session.getAttribute("loggedInUser");
		model.addAttribute("message", "product added successfully");
		model.addAttribute("productList", productDAO.list());
		model.addAttribute("categoryList", categoryDAO.list());
		model.addAttribute("supplierList", supplierDAO.list());
		
		String recipientAddress=email1;
		String subject="User Registration";
		String message="User Registered successfully\n"+
		"The Details ..r.."+"\n User Name:"+usernaam+"\n Phone no:"+user.getPhno();
		
		//prints on console
		System.out.println("Too:"+recipientAddress);
		System.out.println("Subject:"+subject);
		System.out.println("Message:"+message);
		
		//creats a simple e-mail obj.
		SimpleMailMessage email=new SimpleMailMessage();
		email.setTo(recipientAddress);
		email.setSubject(subject);
		email.setText(message);
		
		//sends the e-mail
		mailSender.send(email);			


		return "adminviewproducts";
	}

	String setName;
	List<Product> plist;

	@RequestMapping("GsonCon")
	// @ResponseBody is used whenever angularjs is used
	// for filtering and sorting -angular js
	// (google)gson converts java obj into json(java script obj)

	public @ResponseBody String getValues() throws Exception {
		String result = "";
		plist = productDAO.list();
		Gson gson = new Gson();
		result = gson.toJson(plist);
		return result;
	}
	@RequestMapping(value = "/editproducts{id}")
	public ModelAndView updateProdPage(@PathVariable("id") String id, Model model) throws Exception {
		int i = Integer.parseInt(id);

		model.addAttribute("product", productDAO.get(i));
		
		model.addAttribute("productList", productDAO.list());
		model.addAttribute("supplierList", supplierDAO.list());
		model.addAttribute("categoryList", categoryDAO.list());
		
		System.out.println("edit product in controller");
		ModelAndView mv = new ModelAndView("addproduct");
		return mv;

	}

}
