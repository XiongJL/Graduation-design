package neu.xiong.ELK.design.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;


import neu.xiong.ELK.design.dao.GoodsDao;
import neu.xiong.ELK.design.entity.Goods;

@Controller
@CrossOrigin
public class GoodsController {
	@Autowired 
	private GoodsDao goodsDao;
	
	
	@GetMapping(value="/search")
	public String search(String searchinput,String pageNumberTo ,Model model){
		System.out.println(searchinput);
		String order = "DESC";
		String prop = "goodsId";
		int pageNumber = 0;
		System.out.println();
		if(pageNumberTo!=null&&pageNumberTo!=""){
			 pageNumber = Integer.valueOf(pageNumberTo);
			 System.out.println("页码为："+pageNumber);
		}
		int pageSize = 10;
		/*
		 * 这是在用户的搜索点击后执行的操作，点击后将跳转到显示页面。
		 * 下面的搜索功能需要封装
		 * 在展示页面点击上一页或下一页需要注意边界。
		 */
		Sort sort = new Sort(Sort.Direction.fromString(order), prop);
		Pageable pageable = PageRequest.of(pageNumber, pageSize, sort);
		@SuppressWarnings("unchecked")
		Page<Goods> page = (Page<Goods>) goodsDao.findAll(new Specification<Goods>() {

			@Override
			public Predicate toPredicate(Root<Goods> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				List<Predicate> list = new ArrayList<>();
				if(StringUtils.isNotBlank(searchinput)){
					list.add(cb.like((root.get("goodsInfo").as(String.class)),"%"+searchinput+"%"));
					list.add(cb.like((root.get("goodsName").as(String.class)),"%"+searchinput+"%"));
				}
				Predicate[] predicates = new Predicate[list.size()];
				predicates = list.toArray(predicates);
				return cb.and(predicates);
			}
		},pageable);
		// 查询结果总行数
		long totalElements = page.getTotalElements();	
		// 按照当前分页大小，总页数
		long totalPages = page.getTotalPages();
		List<Goods> list = new ArrayList<Goods>();
		for(Goods goods : page.getContent()){
			//输出商品
			System.out.println(goods.toString());
			list.add(goods);
		}
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("totalPages", totalPages);
		// 当前第几页
		result.put("pageNumber", page.getNumber());
		// 每页几行
		result.put("pageSize", page.getSize());
		// 存入数据
		result.put("data", list);
		// 总行数
		result.put("totalElements", totalElements);
		result.put("searchinput", searchinput);
		model.addAttribute("result", result);
		//总页数
		model.addAttribute("totalPages", page.getTotalPages());
		System.out.println("总页数："+page.getTotalPages());
		return "search";
	}
}
