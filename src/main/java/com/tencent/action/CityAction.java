package com.tencent.action;


import com.opensymphony.xwork2.Action;
import com.tencent.entity.City;
import com.tencent.service.CityService;
import com.tencent.util.JsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@Scope("prototype")
public class CityAction {

	// git dev

	@Autowired
	private CityService cityService;
	private List<City> citys;
	private City city;
	private String name;
	
	//学生添加时展示所有就业城市
	public String showCity(){
		List<City> cityss = cityService.queryAll();
		JsonUtil.JsonAndPrint(cityss);
		return Action.NONE;
	}
	
	
	//查询是否存在
	public String findOne() throws Exception{
		City c = cityService.findOne(name);
		/*HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/plain;charset=utf-8");
		PrintWriter writer = response.getWriter();*/
		//System.out.println(c);
		if(c==null){
			//writer.print("可添加");
			JsonUtil.JsonAndPrint(true);
		}else{
			//writer.print("该城市已存在!!!");
			JsonUtil.JsonAndPrint(false);
		}
		return null;
	}
	
	//添加
	public String add(){
		cityService.addCity(city);
		return "showCity";
	}
	//展示所有
	public String showAllCity(){
		citys = cityService.queryAll();
		return "showCityView";
	}

	public List<City> getCitys() {
		return citys;
	}

	public void setCitys(List<City> citys) {
		this.citys = citys;
	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
