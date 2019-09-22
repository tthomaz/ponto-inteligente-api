CREATE TABLE `tb_empresa` (
  `id` bigint(20) NOT NULL,
  `cnpj` varchar(25) NOT NULL,
  `data_atualizacao` datetime NOT NULL,
  `data_criacao` datetime NOT NULL,
  `razao_social` varchar(150) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

ALTER TABLE `tb_empresa` ADD PRIMARY KEY (`id`);
ALTER TABLE `tb_empresa` MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;
 
 CREATE TABLE `tb_funcionario` (
  `id` bigint(20) NOT NULL,
  `cpf` varchar(20) NOT NULL,
  `data_atualizacao` datetime NOT NULL,
  `data_criacao` datetime NOT NULL,
  `email` varchar(100) NOT NULL,
  `nome` varchar(155) NOT NULL,
  `perfil` varchar(30) NOT NULL,
  `qtd_horas_almoco` float DEFAULT NULL,
  `qtd_horas_trabalho_dia` float DEFAULT NULL,
  `senha` varchar(20) DEFAULT NULL,
  `valor_hora` decimal(19,2) DEFAULT NULL,
  `empresa_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

ALTER TABLE `tb_funcionario` ADD PRIMARY KEY (`id`);

ALTER TABLE `tb_funcionario` MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;

ALTER TABLE `tb_funcionario` ADD CONSTRAINT `tb_funcionario_ibfk_1` FOREIGN KEY (`empresa_id`) REFERENCES `tb_empresa`(`id`);

CREATE TABLE `tb_lancamento` (
  `id` bigint(20) NOT NULL,
  `data` datetime NOT NULL,
  `descricao` varchar(255) DEFAULT NULL,
  `localizacao` varchar(50) DEFAULT NULL,
  `data_criacao` datetime NOT NULL,
  `data_atualizacao` datetime NOT NULL,
  `tipo` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

ALTER TABLE `tb_lancamento`  ADD PRIMARY KEY (`id`);

ALTER TABLE `tb_lancamento`  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;

ALTER ALTER TABLE `tb_lancamento` ADD CONSTRAINT `tb_lancamento_ibfk_1` FOREIGN KEY (`funcionario_id`) REFERENCES `tb_funcionario`(`id`);
