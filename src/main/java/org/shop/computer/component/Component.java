package org.shop.computer.component;

import lombok.Getter;
import lombok.ToString;
import org.shop.util.exception.ComponentCreationException;

@Getter
@ToString
public abstract class Component {

  /**
   * Name of the component
   */
  private final String name;

  /**
   * Price of the component, represented in the smallest, indivisible currency value (e.g. cent)
   */
  private final int price;

  protected Component(String name, int price) {
    if (price < 0) {
      throw new ComponentCreationException("Could not create component with negative price");
    }

    this.name = name;
    this.price = price;
  }
}
