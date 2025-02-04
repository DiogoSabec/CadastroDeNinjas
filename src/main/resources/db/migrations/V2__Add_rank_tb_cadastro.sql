-- V2: Migrations to add column rank in the cadastro table
ALTER TABLE tb_cadastro
ADD COLUMN rank VARCHAR(255);