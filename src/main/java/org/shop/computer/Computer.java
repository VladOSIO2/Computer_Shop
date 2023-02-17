package org.shop.computer;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.shop.computer.component.Motherboard;
import org.shop.computer.component.Processor;
import org.shop.computer.component.RamStick;
import org.shop.util.exception.ComponentMismatchException;

public abstract class Computer implements Product {

  private final String name;
  private final Motherboard motherboard;
  private final Processor processor;
  private final List<RamStick> ramSticks;

  protected Computer(String name, Motherboard motherboard, Processor processor,
      List<RamStick> ramSticks) {
    if (!motherboard.getSocket().equals(processor.getSocket())) {
      throw new ComponentMismatchException("Processor socket: '" + processor.getSocket() +
          "' do not match the motherboard socket: '" + motherboard.getSocket() + "'");
    }

    if (ramSticks.isEmpty()) {
      throw new ComponentMismatchException("Install at least one RAM stick in the computer");
    }

    if (ramSticks.size() > motherboard.getRamSlotCount()) {
      throw new ComponentMismatchException(
          "Could not install " + ramSticks.size() + " RAM sticks, the motherboard can only handle "
              + motherboard.getRamSlotCount());
    }

    this.name = name;
    this.motherboard = motherboard;
    this.processor = processor;
    this.ramSticks = Collections.unmodifiableList(ramSticks);
  }

  @Override
  public String getName() {
    return name;
  }

  @Override
  public int getPrice() {
    int price = 0;
    for (RamStick ram : ramSticks) {
      price += ram.getPrice();
    }
    return price + processor.getPrice() + motherboard.getPrice();
  }

  @Override
  public Map<String, String> getProperties() {
    Map<String, String> properties = new HashMap<>();
    properties.put("Motherboard", motherboard.toString());
    properties.put("Processor", processor.toString());
    properties.put("RAM", ramSticks.toString());

    return properties;
  }
}
