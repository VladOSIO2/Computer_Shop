package org.shop.util.db;

import java.util.List;
import org.shop.computer.Computer;
import org.shop.computer.DesktopComputer;
import org.shop.computer.LaptopComputer;
import org.shop.computer.component.Battery;
import org.shop.computer.component.ComputerCase;
import org.shop.computer.component.Motherboard;
import org.shop.computer.component.Processor;
import org.shop.computer.component.RamStick;
import org.shop.computer.component.Socket;

public class DBMock {

  private DBMock() {
  }

  public static List<Computer> getAllComputers() {
    Processor intelProcessor = new Processor("Intel Core I5-10400", 15000, Socket.LGA1200, 6);
    Processor amdProcessor = new Processor("AMD Ryzen 5 3600", 10000, Socket.AM4, 6);

    Motherboard intelMotherboard1 = new Motherboard(
        "Intel desktop motherboard", 8000, Socket.LGA1200, 4);
    Motherboard intelMotherboard2 = new Motherboard(
        "Intel laptop motherboard", 8500, Socket.LGA1200, 2);
    Motherboard amdMotherboard1 = new Motherboard(
        "AMD desktop motherboard", 7500, Socket.AM4, 4);
    Motherboard amdMotherboard2 = new Motherboard(
        "AMD laptop motherboard", 9000, Socket.AM4, 2);

    RamStick laptopRAMStick = new RamStick("laptop DDR4 RAM", 4000, 8192);
    RamStick desktopRAMstick = new RamStick("desktop DDR4 RAM", 1950, 4096);

    Battery battery = new Battery("universal laptop battery", 5000, 4000);
    ComputerCase computerCase = new ComputerCase("case", 1500, "black");

    Computer intelDesktop = new DesktopComputer("intelDesktop", intelMotherboard1, intelProcessor,
        List.of(desktopRAMstick, desktopRAMstick), computerCase);
    Computer amdDesktop = new DesktopComputer("amdDesktop", amdMotherboard1, amdProcessor,
        List.of(desktopRAMstick, desktopRAMstick), computerCase);
    Computer intelLaptop = new LaptopComputer("intelLaptop", intelMotherboard2, intelProcessor,
        List.of(laptopRAMStick, laptopRAMStick), battery);
    Computer amdLaptop = new LaptopComputer("amdLaptop", amdMotherboard2, amdProcessor,
        List.of(laptopRAMStick, laptopRAMStick), battery);
    return List.of(intelDesktop, amdDesktop, intelLaptop, amdLaptop);
  }
}
