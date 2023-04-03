package priv.klochkov.constructionwork;

import priv.klochkov.constructionwork.dao.KindMaterialDAO;
import priv.klochkov.constructionwork.entity.KindMaterialEntity;

import java.math.BigDecimal;

public class A {
    public static void main(String[] args) {
        //create
        KindMaterialEntity kindMaterial1 = KindMaterialEntity.builder()
                .name("board")
                .unit("M2")
                .cost(new BigDecimal("100"))
                .build();
        KindMaterialDAO kindMaterialDAO = new KindMaterialDAO();
        kindMaterialDAO.create(kindMaterial1);

        KindMaterialEntity kindMaterial2 = KindMaterialEntity.builder()
                .name("stone")
                .unit("M3")
                .cost(new BigDecimal("300"))
                .build();
        kindMaterialDAO.create(kindMaterial2);


        KindMaterialEntity kindMaterial3 = KindMaterialEntity.builder()
                .name("plaster")
                .unit("M2")
                .cost(new BigDecimal("500"))
                .build();
        kindMaterialDAO.create(kindMaterial3);

        //update
        kindMaterial1.setCost(new BigDecimal("5000"));
        kindMaterialDAO.update(kindMaterial1);

        //delete
        kindMaterialDAO.delete(kindMaterial2);

        //read
        System.out.println("Read by id   " + kindMaterialDAO.read(kindMaterial3.getId()));

        //readByName
        System.out.println("Read by name     " + kindMaterialDAO.readByName("plaster"));

        //readAll
        System.out.println("Read All names     " + kindMaterialDAO.getAllNamesKindsMaterial());
    }
}
