# Configuração da máquina para rodar o projeto

- Criar uma pasta em C: > Dev > Workspace. Dentro de "Dev" devem contém o Eclipse, o Maven. Dentro de "Workspace" deve conter o repositório clonado do GitHub.
- Utilizar Eclipse IDE 2022.06+ e selecionar a pasta de workspace criado anteriormente.
- Utilizar GitHub Desktop pra atualizar o projeto no GitHub.
- Ter Java instalado na máquina.
- No eclipse, instalar a extensão do SpringBoot para rodar o programa.
- Baixar o Maven 6.8.2 e adicionar na pasta Dev.

# Rodar o Projeto

- Clonar o projeto no GitHub Desktop
- No Eclipse, ir em File > Import > Maven Project > Existing Maven Project.
- Após importar o projeto, clicar com o botão direito no projeto, no package Explorer do lado esquerdo, Run as > SpringBoot application.
- Ao rodar o projeto pela primeira vez, é provável que de erro ao tentar instalar o npm. Precisa parar o projeto e realizar o processo do ponto acima.

# Processo feito no GitHub Desktop

- Ir em Branch > New branch... e dar um nome à branch
- Clicar em Publish Branch.
- Ao commitar, informar o que foi alterado na descrição.
- Após commitar, mudar para branch MASTER e verificar que ela está atualizada.
- Voltar pra sua branch, clicar em branch > rebase current branch.
- Alterar para master, ir em branch > Merge into... Após realizar esses processos, ir em Current Branch e excluir a branch que criou e marcar a opção "Yes, delete this branch...".


