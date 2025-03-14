-- V2: Migrations to add rank column to table tb_ninja

ALTER TABLE tb_ninja
ADD COLUMN rank VARCHAR(50);