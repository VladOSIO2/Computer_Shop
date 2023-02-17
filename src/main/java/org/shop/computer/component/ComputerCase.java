package org.shop.computer.component;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class ComputerCase extends Component {

  /**
   * Color of the computer case
   */
  public final String color;

  public ComputerCase(String name, int price, String color) {
    super(name, price);
    this.color = color;
  }
}
