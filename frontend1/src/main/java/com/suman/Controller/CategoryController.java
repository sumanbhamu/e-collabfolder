package com.suman.Controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.suman.ecom.dao.CategoryDAO;
import com.suman.ecom.model.Category;

@Controller

public class CategoryController {
	
	@Autowired
	CategoryDAO categoryDAO;

	@Autowired
	Category category;
	// Creates empty obj and takes values frm user

		@ModelAttribute
		public Category returnObject1() {
			return new Category();

		}

		@RequestMapping("/addcategory")
		public ModelAndView ShowAddCategory(Model model) {
			ModelAndView mv = new ModelAndView("addcategory");

			model.addAttribute("categoryList", categoryDAO.list());
			System.out.println("added category details  in controller");

			return mv;
		}

		/*
		 * action of addcategory
		 */

		@RequestMapping(value = "/addcat", method = RequestMethod.POST)
		public String addCate(@ModelAttribute("category") Category cate) {
			if (cate.getCat_id() == 0) {
				// new category, add it

				categoryDAO.save(cate);
				System.out.println("adding of new category in controller");
			} else {
				// existing category, call update

				categoryDAO.update(cate);
				System.out.println("addsup update method of category in controller");
			}

			return "redirect:/addcategory";

		}

		

		/* delete category... */
		@RequestMapping(value = "/deletecategory{id}")
		public ModelAndView showDeleteCategory(@PathVariable("id") String id, Model model) throws Exception {

			int i = Integer.parseInt(id);

			category = categoryDAO.get(i);

			System.out.println("category deleteeeee");

			ModelAndView mv = new ModelAndView("addcategory");

			categoryDAO.delete(category);
			mv.addObject("addcategory", 0);

			System.out.println("delete Id:" + id);

			return mv;

		}

		@RequestMapping(value = "/editcategory{id}")
		public ModelAndView updateCatPage(@PathVariable("id") String id, Model model) throws Exception {
			int i = Integer.parseInt(id);

			model.addAttribute("category", categoryDAO.get(i));
			model.addAttribute("CategoryList", categoryDAO.list());
			System.out.println("edit category in controller");
			ModelAndView mv = new ModelAndView("addcategory");
			return mv;

		}


}
