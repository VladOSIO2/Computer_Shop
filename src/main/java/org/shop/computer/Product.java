package org.shop.computer;

import java.util.Map;


/**
 * Interface representing any abstract product, that could be sold in the shop
 */
public interface Product {

  /**
   * Each product should have its own name
   * @return name of the product
   */
  String getName();

  /**
   * Each product should have its price, which may be its own price
   * or an accumulated price of all product's parts or components
   * @return price of the product
   */
  int getPrice();

  /**
   * Each product should have some properties, that describe that product
   * provided as a map "property":"property info"
   * @return property map that describes that product
   */
  Map<String, String> getProperties();
}
