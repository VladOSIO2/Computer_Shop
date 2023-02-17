package org.shop.computer.component;

import lombok.Getter;
import lombok.ToString;
import org.shop.util.exception.ComponentCreationException;

@Getter
@ToString(callSuper = true)
public class Battery extends Component {

  /**
   * Battery capacity in mAh
   */
  private final int capacity;

  public Battery(String name, int price, int capacity) {
    super(name, price);
    if (capacity <= 0) {
      throw new ComponentCreationException("Battery capacity should be positive!");
    }

    this.capacity = capacity;
  }
}
