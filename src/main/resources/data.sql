INSERT INTO TB_PESSOA (ID_PESSOA, NOME, SOBRE_NOME, IDADE, ATIVO) VALUES (1, 'Maikon', 'Canuto', 21, TRUE);

INSERT INTO TB_USUARIO (ID_USUARIO, NO_USUARIO, SENHA, ATIVO) VALUES (1, 'maikoncanuto', '123', TRUE);

INSERT INTO TB_PERFIL (ID, NOME, DESCRICAO, ATIVO) VALUES (1, 'ROLE_ADMIN', 'Administrador do sistema', TRUE);

INSERT INTO TB_USUARIO_PERFIL (ID_USUARIO, ID_PERFIL) VALUES (1, 1);