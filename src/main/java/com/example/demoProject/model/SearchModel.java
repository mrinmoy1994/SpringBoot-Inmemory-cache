package com.example.demoProject.model;

import java.util.Arrays;

public class SearchModel {
	
	//list of types for product search
	private String[] types;
	
	//list of colors for product search
	private String[] colors;
	
	//list of sizes for product search
	private int[] sizes;
	
	//list of sellers for product search
	private String[] sellers;
	
	//list of brands for product search
	private String[] brands;
	
	//list of skus for product search
	private String[] skus;
	
	//starting price range for product search
	private float startingPrice;
	
	//end price range for product search
	private float endPrice;
	
	public String[] getSkus() {
		return skus;
	}

	public void setSkus(String[] skus) {
		this.skus = skus;
	}

	public boolean matchPrice(float price) {
		boolean flag = false;

		if(price >= startingPrice && price<= endPrice)
			flag = true;
		else if(price >= startingPrice && endPrice == 0.0)
			flag=true;
		
		return flag;
	}
	
	public boolean matchSize(int size) {
		boolean flag = false;
		if(sizes==null || sizes.length == 0)
			return true;
		for(int s : sizes)
		{
			if(s==size)
			{
				flag=true;
				break;
			}
		}
		return flag;
	}
	
	public boolean matchType(String type) {
		boolean flag = false;
		if(types==null || types.length==0)
			return true;
		for(String s : types)
		{
			if(s.equalsIgnoreCase(type))
			{
				flag=true;
				break;
			}
		}
		return flag;
	}
	
	public boolean matchSku(String sku) {
		boolean flag = false;
		if(skus==null || skus.length == 0)
			return true;
		for(String s : skus)
		{
			if(s.equalsIgnoreCase(sku))
			{
				flag=true;
				break;
			}
		}
		return flag;
	}
	
	public boolean matchColor(String color) {
		boolean flag = false;
		if(colors==null || colors.length == 0)
			return true;
		for(String s : colors)
		{
			if(s.equalsIgnoreCase(color))
			{
				flag=true;
				break;
			}
		}
		return flag;
	}
	
	public boolean matchSeller(String seller) {
		boolean flag = false;
		if(sellers==null || sellers.length == 0)
			return true;
		for(String s : sellers)
		{
			if(s.equalsIgnoreCase(seller))
			{
				flag=true;
				break;
			}
		}
		return flag;
	}
	
	public boolean matchBrand(String brand) {
		boolean flag = false;
		if(brands==null || brands.length == 0)
			return true;
		for(String s : brands)
		{
			if(s.equalsIgnoreCase(brand))
			{
				flag=true;
				break;
			}
		}
		return flag;
	}
	
	
	public String[] getTypes() {
		return types;
	}

	public void setTypes(String[] types) {
		this.types = types;
	}

	public String[] getColors() {
		return colors;
	}

	public void setColors(String[] colors) {
		this.colors = colors;
	}

	public int[] getSizes() {
		return sizes;
	}

	public void setSizes(int[] sizes) {
		this.sizes = sizes;
	}

	public String[] getSellers() {
		return sellers;
	}

	public void setSellers(String[] sellers) {
		this.sellers = sellers;
	}

	public String[] getBrands() {
		return brands;
	}

	public void setBrands(String[] brands) {
		this.brands = brands;
	}

	public float getStartingPrice() {
		return startingPrice;
	}

	public void setStartingPrice(float startingPrice) {
		this.startingPrice = startingPrice;
	}

	public float getEndPrice() {
		return endPrice;
	}

	public void setEndPrice(float endPrice) {
		this.endPrice = endPrice;
	}

	@Override
	public String toString() {
		return "SearchModel [type=" + Arrays.toString(types) + ", color=" + Arrays.toString(colors) + ", size="
				+ Arrays.toString(sizes) + ", seller=" + Arrays.toString(sellers) + ", SKU=" + Arrays.toString(skus)
				+ ", brand=" + Arrays.toString(brands) + ", startingPrice=" + startingPrice + ", endPrice=" + endPrice
				+ "]";
	}
	
	
}
