import java.util.ArrayList;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        System.out.print("=================| \033[1;34mCadastro alunos do curso\033[m |=================");
        Scanner input = new Scanner(System.in);
        Scanner input1 = new Scanner(System.in);
        boolean loop = true;
        int escolha;
        ArrayList<ArrayList<String>> todos = new ArrayList<>();
        ArrayList<String> todos1 = new ArrayList<>();
        ArrayList<String> aluno = new ArrayList<>();
        int cadas = 0;
        while (loop) {
            System.out.print("\n[0]Inserir [1]Alterar [2]Deletar [3]Buscar [4]Listar [5]Sair\nDigite: ");
            escolha = input1.nextInt();
            if (escolha >= 0 && escolha <= 5) {
                if (escolha == 0) {
                    String name, endereco, estadocivil = "a", idade, renda;
                    int estadocivil1;

                    System.out.print("Nome: ");
                    name = input.nextLine();
                    System.out.print("Idade: ");
                    idade = input.nextLine();
                    System.out.print("Endereço: ");
                    endereco = input.nextLine();
                    System.out.print("Renda Mensal: ");
                    renda = input.nextLine();
                    System.out.println("Estado Cívil: [0]Solteiro [1]Casado");
                    while (loop) {
                        System.out.print("Digite: ");
                        estadocivil1 = input1.nextInt();
                        if (estadocivil1 == 0) {
                            estadocivil = "Solteiro";
                            loop = false;
                        } else if (estadocivil1 == 1) {
                            estadocivil = "Casado";
                            loop = false;
                        }
                    }
                    aluno.add(name);
                    aluno.add(idade);
                    aluno.add(endereco);
                    aluno.add(renda);
                    aluno.add(estadocivil);
                    System.out.printf("O número do seu cadastro é: %s\n",cadas);
                    cadas ++;
                    todos.add(aluno);
                    aluno = new ArrayList<>();
                    loop = true;
                } else if (escolha == 1) {
                    for (int n = 0; n < todos.size(); n++) {
                        System.out.printf("[" + n + "] "+ todos.get(n).get(0));
                        if (n % 2 == 0)  {
                            System.out.print("\n");
                        }
                    }
                    System.out.print("\nQual deseja alterar? ");
                    int alt = 1;
                    while (loop) {
                        alt = input1.nextInt();
                        if (alt >= 0 && alt < todos.size()) {
                            loop = false;
                        }
                    }
                    loop = true;
                    System.out.println("[0]Nome [1]Idade [2]Endereço [3]Renda Mensal [4]Estado Cívil");
                    int alt1 = 0;
                    while (loop) {
                        System.out.print("Digite: ");
                        alt1 = input1.nextInt();
                        if (alt1 >= 0 && alt1 < 5) {
                            loop = false;
                        }
                    }
                    String alter = "a";
                    if (alt1 == 4) {
                        System.out.println("Estado Cívil: [0]Solteiro [1]Casado");
                        while (true) {
                            System.out.print("Digite: ");
                            int alter1 = input1.nextInt();
                            loop = true;
                            if (alter1 == 0) {
                                alter = "Solteiro";
                                break;
                            } else if (1 == alter1) {
                                alter = "Casado";
                                break;
                            }
                        }
                    }else {
                        System.out.print("Insira: ");
                        alter = input.nextLine();
                        loop = true;
                    }
                    System.out.printf("Deseja alterar " + todos.get(alt).get(alt1) + " por: " + alter + "?\n[0]Sim [1]Não Digite: ");
                    int yes = -1;
                    while (true) {
                        yes = input1.nextInt();
                        if (yes == 0) {
                            todos1 = todos.get(alt);
                            todos1.set(alt1, alter);
                            todos.set(alt, todos1);
                            todos1 = new ArrayList<>();
                            break;
                        } else if (yes == 1) {
                            System.out.print("Operação canselada");
                            break;
                        } else {
                            System.out.print("Insira um número válido");
                        }

                    }
                }else if (escolha == 2) {
                    int dele = 0;
                    for (int n = 0; n < todos.size(); n++) {
                        System.out.printf("[" + n + "] " + todos.get(n).get(0) + "\n");
                    }
                    System.out.printf("[%s] para cancelar", (todos.size() + 1));
                    while (true) {
                        System.out.print("\nQual deseja excluir: ");
                        dele = input1.nextInt();
                        if (dele >= 0 && dele < todos.size()) {
                            todos.remove(dele);
                            System.out.print("Removido com sucesso!");
                            break;
                        } else if (dele == todos.size() + 1) {
                            System.out.print("Operação cancelada");
                            break;
                        }
                    }
                } else if (escolha == 3) {
                    int ncadas;
                    System.out.print("\nDigite o número de cadastro do aluno: ");
                    ncadas = input.nextInt();
                    todos1 = todos.get(ncadas);
                    System.out.printf("Nome: %s | Idade: %s anos\nEndereço: %s | Renda: R$%s\nEstado Cívil: %s\n",
                            todos1.get(0), todos1.get(1), todos1.get(2), todos1.get(3), todos1.get(4));
                }else if (escolha == 4) {
                    for (ArrayList<String> todo : todos) {
                        System.out.printf("\nNome: %s | Idade: %s anos\nEndereço: %s | Renda: R$%s \nEstado Cívil: %s\n",
                                todo.get(0), todo.get(1), todo.get(2), todo.get(3), todo.get(4));

                    }
                } else if (escolha == 5){
                    break;
                }else {
                    System.out.println("\033[1;31mInsira um número de 0 a 5\033[m");
                }
            }
        }
    }
}