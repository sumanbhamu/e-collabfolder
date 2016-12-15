package com.suman.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.suman.ecom.dao.SupplierDAO;
import com.suman.ecom.model.Supplier;

@Controller

public class SupplierController {

	@Autowired
	Supplier supplier;

	@Autowired
	SupplierDAO supplierDAO;

	@ModelAttribute
	public Supplier returnObject2() {
		return new Supplier();

	}

	@RequestMapping("/addsupplier")
	public ModelAndView ShowAddSupplier(Model model) {
		ModelAndView mv = new ModelAndView("addsupplier");

		model.addAttribute("supplierList", supplierDAO.list());
		System.out.println("added supplier details  in controller");

		return mv;
	}

	/* action of addsupplier */
	@RequestMapping(value = "/addsup", method = RequestMethod.POST)
	public String addSupp(@ModelAttribute("supplier") Supplier su) {
		if (su.getSupplier_id() == 0) {
			// new supplier, add it

			supplierDAO.savOrUpdate(su);
			System.out.println("adding of new supplier in controller");
		} else {
			// existing supplier, call update

			supplierDAO.update(su);
			System.out.println("addsup update method of supplier in controller");
		}

		return "redirect:/addsupplier";

	}

	/* delete supplier... */
	@RequestMapping(value = "/deletesupplier{id}")
	public ModelAndView showDeleteSupplier(@PathVariable("id") String id, Model model) throws Exception {

		int i = Integer.parseInt(id);

		supplier = supplierDAO.get(i);

		System.out.println("supplier deleteeeee");

		ModelAndView mv = new ModelAndView("addsupplier");

		supplierDAO.delete(supplier);
		mv.addObject("addsupplier", 0);

		System.out.println("delete Id:" + id);

		return mv;

	}

	/*
	 * /////////////////////////
	 */

	@RequestMapping(value = "/editsupplier{id}")
	public ModelAndView UpdatesuppPage(@PathVariable("id") String id, Model model) throws Exception {
		int i = Integer.parseInt(id);

		model.addAttribute("supplier", supplierDAO.get(i));
		model.addAttribute("SupplierList", supplierDAO.list());
		System.out.println("edit supplier in controller");
		ModelAndView mv = new ModelAndView("addsupplier");
		return mv;

	}
}