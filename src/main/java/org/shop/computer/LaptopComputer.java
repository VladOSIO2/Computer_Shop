package org.shop.computer;

import java.util.List;
import java.util.Map;
import org.shop.computer.component.Battery;
import org.shop.computer.component.Motherboard;
import org.shop.computer.component.Processor;
import org.shop.computer.component.RamStick;

public class LaptopComputer extends Computer {

  private final Battery battery;

  public LaptopComputer(String name, Motherboard motherboard, Processor processor,
      List<RamStick> ramSticks, Battery battery) {
    super(name, motherboard, processor, ramSticks);
    this.battery = battery;
  }

  @Override
  public int getPrice() {
    return super.getPrice() + battery.getPrice();
  }

  @Override
  public Map<String, String> getProperties() {
    Map<String, String> properties = super.getProperties();
    properties.put("Battery", battery.toString());

    return properties;
  }
}
