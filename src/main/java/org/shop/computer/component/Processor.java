package org.shop.computer.component;

import lombok.Getter;
import lombok.ToString;
import org.shop.util.exception.ComponentCreationException;

@Getter
@ToString(callSuper = true)
public class Processor extends Component {

  /**
   * The socket of the processor
   */
  private final Socket socket;

  /**
   * Amount of cores the processor has
   */
  private final int cores;

  public Processor(String name, int price, Socket socket, int cores) {
    super(name, price);
    if (cores <= 0) {
      throw new ComponentCreationException("The processor should have at least one core!");
    }

    this.cores = cores;
    this.socket = socket;
  }
}
