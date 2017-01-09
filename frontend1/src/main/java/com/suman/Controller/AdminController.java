package com.suman.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.suman.ecom.dao.CartDAO;
import com.suman.ecom.dao.ProductDAO;
import com.suman.ecom.dao.UserDAO;
import com.suman.ecom.model.Cart;
import com.suman.ecom.model.Product;
import com.suman.ecom.model.User;

@Controller

public class AdminController {

	@Autowired
	CartDAO cartDAO;

	@Autowired
	Cart cart;

	@Autowired
	ProductDAO productDAO;

	@Autowired
	Product product;

	@Autowired
	UserDAO userDAO;

	@Autowired
	User user;

	@RequestMapping("/adminhome")
	public String ShowAdminHome() {
		return "adminhome";
	}
	@RequestMapping(value = "/buy{pid}", method = RequestMethod.POST)
	public ModelAndView buyproductPage(@Valid @PathVariable("pid") int pid, Model model, HttpServletRequest request) {

		model.addAttribute("cart", new Cart());

		HttpSession session = request.getSession(false);
		// String email1 = (String) session.getAttribute("email");

		String name1 = (String) session.getAttribute("loggedInUser");

		if (name1 == null) {

			ModelAndView mv = new ModelAndView("test");
			System.out.println("........check .login user");

			return mv;
		}

		int x1 = (Integer) session.getAttribute("loggedInUserID");

		product = productDAO.get(pid);
		session.setAttribute("ppprice", product.getProd_price());
		int pprice = (Integer) session.getAttribute("ppprice");

		cart.setQuantity(1);
		cart.setProd_id(pid);
		cart.setUser_id(x1);
		cart.setCartuser(userDAO.getbyid(x1));
		cart.setCartproduct(product);
		cart.setPrice(pprice);

		cartDAO.save(cart);

		System.out.println("ading to 1cartttttttt..." + cart.getQuantity());
		System.out.println("loggedinuserid===" + "....x..." + x1 + ".........apple." + name1);
		System.out.println("ading to 2cartttttttt.." + pid);
		System.out.println("ading to 3cartttttttt..." + x1 + "\t ");

		System.out.println("price...." + product.getProd_price() + "." + ".....\n............pprice..." + pprice);

		session.setAttribute("cartpic11", cart.getCartproduct().getProd_name());
		System.out.println("cartpic...." + cart.getCartproduct().getProd_name());

		System.out.println("ading to cart");

		ModelAndView mv = new ModelAndView("mycart");
		model.addAttribute("productList", productDAO.list());

		mv.addObject("cartList", cartDAO.listcartproducts(x1));


		mv.addObject("Total", cartDAO.totalprice(x1));

		return mv;

	}

	@RequestMapping(value = "/mycart{id}")
	public ModelAndView viewmycart1(@PathVariable("id") int id) {
		ModelAndView mv = new ModelAndView("mycart");
		mv.addObject("cartList", cartDAO.listcartproducts(id));
		// mv.addObject("cartprice", cartDAO.totalprice(id));
		return mv;

	}
	
	
	@RequestMapping("/bill")
	public String showHome() {
				
		
		return "bill";

	}
}
