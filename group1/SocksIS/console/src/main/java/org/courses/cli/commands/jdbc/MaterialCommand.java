package org.courses.cli.commands.jdbc;

import org.courses.data.DAO.DAO;
import org.courses.domain.hbm.Material;

import java.util.Scanner;

public class MaterialCommand extends CrudCommand<Material, Integer> {
    private Scanner scanner;

    public MaterialCommand(DAO<Material, Integer> dao, Scanner scanner) {
        super(dao, Material.class);
        this.scanner = scanner;
    }

    @Override
    protected void readEntity(Material material) {
        System.out.print("\tname: ");
        if (scanner.hasNext()) {
            String name = scanner.nextLine();
            material.setName(name);
        }
    }

    @Override
    protected Integer convertId(String id) {
        return Integer.parseInt(id);
    }

    @Override
    protected void print(Material m) {
        System.out.println(String.format("\tMaterial { id: %d, name: %s }", m.getId(), m.getName()));
    }
}
