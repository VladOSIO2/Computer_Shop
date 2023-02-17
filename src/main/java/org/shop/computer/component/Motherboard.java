package org.shop.computer.component;

import lombok.Getter;
import lombok.ToString;
import org.shop.util.exception.ComponentCreationException;


@Getter
@ToString(callSuper = true)
public class Motherboard extends Component {

  /**
   * The socket of the motherboard
   */
  private final Socket socket;

  /**
   * The count of the slots for RAM available on the motherboard
   */
  private final int ramSlotCount;

  public Motherboard(String name, int price, Socket socket, int ramSlotCount) {
    super(name, price);
    if (ramSlotCount <= 0) {
      throw new ComponentCreationException("The motherboard should have at least 1 RAM slot");
    }

    this.socket = socket;
    this.ramSlotCount = ramSlotCount;
  }
}
