package org.shop.computer;


import java.util.List;
import java.util.Map;
import org.shop.computer.component.ComputerCase;
import org.shop.computer.component.Motherboard;
import org.shop.computer.component.Processor;
import org.shop.computer.component.RamStick;

public class DesktopComputer extends Computer {

  private final ComputerCase computerCase;

  public DesktopComputer(String name, Motherboard motherboard,
      Processor processor,
      List<RamStick> ramSticks, ComputerCase computerCase) {
    super(name, motherboard, processor, ramSticks);
    this.computerCase = computerCase;
  }

  @Override
  public int getPrice() {
    return super.getPrice() + computerCase.getPrice();
  }

  @Override
  public Map<String, String> getProperties() {
    Map<String, String> properties = super.getProperties();
    properties.put("Computer case", computerCase.toString());

    return properties;
  }
}
