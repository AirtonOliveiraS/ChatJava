import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class Cliente {
    public static void main(String[] args) {
        

        try{


            Socket cliente = new Socket("127.0.0.1",7000);

            Scanner teclado = new Scanner(System.in);
            Scanner chegada = new Scanner(cliente.getInputStream());

            PrintStream saida = new PrintStream(cliente.getOutputStream());

            String msg="";
            do {
                System.out.println("Mensagem a ser enviada:  ");
                msg = teclado.nextLine();
                saida.println(msg);

                String resposta = chegada.nextLine();
                System.out.println("A resposta para("+ msg+") :" + resposta );
                System.out.println("-------------------------------");


                
            } while (msg.length()!=0);

            cliente.close();




        }catch(Exception e){
            System.out.println("Falha na conexão com o Servidor");
        }
    }

}