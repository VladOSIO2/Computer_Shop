package org.shop.computer.component;

import lombok.Getter;
import lombok.ToString;
import org.shop.util.exception.ComponentCreationException;

@Getter
@ToString(callSuper = true)
public class RamStick extends Component {

  /**
   * the memory capacity of the RAM stick in MB
   */
  private final int capacity;

  public RamStick(String name, int price, int capacity) {
    super(name, price);
    if (capacity <= 0) {
      throw new ComponentCreationException("RAM capacity should be positive!");
    }

    this.capacity = capacity;
  }

}
