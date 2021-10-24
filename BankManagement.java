package bank;

import java.util.*;
import java.io.*;

public class BankManagement{

    public static ArrayList<BankAccount> readData(String fName){
    /* Cần đọc dữ liệu từ tệp fName theo quy tắc:
        Thông tin cho mỗi đối tượng đặt trên 01 dòng theo thứ tự:
        accountNumber, firstName, lastName, password, balance;
        Nếu chữ số đầu của accountNumber là '1' thì coi là SavingsAccount
        và thông tin cuôi dòng là interestRate; ngược lại coi là CheckingAccount.
        Các trường cách nhau bởi ít nhất 01 khoảng trắng.
        Dùng try ... catch để xử lý ngoại lệ khi đọc tệp! Nếu không đọc được tệp cần hiển thị thông báo
        với đoạn đầu là: "Cannot open file" và phần tên tệp, các thông tin lỗi.
        Nếu thành công, trả về ArrayList các đối tượng đã đọc được.
        Bổ sung mã lệnh tương ứng - Có thể sửa giá trị trả về của return nhưng cần giữ nguyên kiểu trả về.
    */
        ArrayList<BankAccount> data = new ArrayList<>();
        File file = new File(fName);
        try {
            Scanner in = new Scanner(file);
            if(in !=null) {
                while(in.hasNextLine()) {
                    BankAccount res;
                    String accountNumber = in.next();
                    String firstName = in.next();
                    String lastName = in.next();
                    String password = in.next();
                    double balance = in.nextDouble();
                    if(accountNumber.charAt(0)=='1')
                    {
                        double interestRate = in.nextDouble();
                        res = new SavingsAccount(accountNumber, firstName, lastName, password, balance, interestRate);
                    }

                    else
                        res = new CheckingAccount(accountNumber, firstName, lastName, password, balance);
                    if(in.hasNextLine())
                        in.nextLine();
                    data.add(res);
                }
            }
            return data;
        } catch(FileNotFoundException e) {
            System.out.println("Cannot open file to read!\n");
            return null;
        }
    }


    public static void displayList(ArrayList<BankAccount> listAccount){

        /* Bổ sung mã lệnh để in xâu tương ứng trả về bởi toString() của mỗi đối tượng
            chú ý phương thức cần thực hiện được với cả SavingsAccount và CheckingAccount
            và thông tin tương ứng cho mỗi trường hợp */
        for (int i = 0; i < listAccount.size(); i++) {
            System.out.println(listAccount.get(i).toString());
        }
    }

    public static ArrayList<BankAccount> listOfSavingsAccount(ArrayList<BankAccount> listAccount){
        ArrayList<BankAccount> listSavingsAccount = new  ArrayList<BankAccount>();
        // Bổ sung mã lệnh để tách các SavingsAccount từ listAccount ra thành một ArrayList riêng
        for (int i = 0; i < listAccount.size(); i++) {
            if (listAccount.get(i).getClass().getSimpleName().equals("SavingsAccount")) {
                listSavingsAccount.add(listAccount.get(i));
            }
        }
        return listSavingsAccount;
    }

    public static ArrayList<BankAccount> listOfCheckingAccount(ArrayList<BankAccount> listAccount){
        ArrayList<BankAccount> listSavingsAccount = new  ArrayList<BankAccount>();
        // Bổ sung mã lệnh để tách các CheckingAccount từ listAccount ra thành một ArrayList riêng
        for (int i = 0; i < listAccount.size(); i++) {
            if (listAccount.get(i).getClass().getSimpleName().equals("CheckingAccount")) {
                listSavingsAccount.add(listAccount.get(i));
            }
        }
        return listSavingsAccount;
    }

    public static void sortByBalance(ArrayList<BankAccount> listAccount){

        // Bổ sung mã lệnh để sắp xếp listAccount theo thứ tự tăng dần của balance
        for (int i = 0; i < listAccount.size() - 1; i++) {
            for (int j = i + 1; j < listAccount.size(); j++) {
                if (listAccount.get(i).getBalance() > listAccount.get(j).getBalance()) {
                    BankAccount temp = listAccount.get(i);
                    listAccount.set(i, listAccount.get(j));
                    listAccount.set(j, temp);
                }
            }
        }
    }

    public static void saveToFile(ArrayList<BankAccount> listAccount, String fileName){

        try{

            /* Bổ sung mã lệnh để mở tệp fileName và ghi thông tin các Account trong listAccount vào tệp
                Thông tin được ghi trên từng dòng cho mỗi trường theo thứ tự: accountNumber, firstName, lastName,
                balance (2 chữ số phần thập phân), sau đó nếu là SavingsAccount thì thêm interestRate, ngược lại
                thêm transactionCount.
               + Mẫu thông tin ghi cho SavingsAccount cần tương đương với:
                    format("%s%n%s %s%n%.2f%n%.3f%n", accountNumber, firstName, lastName, balance, interestRate);

               + Mẫu thông tin ghi cho CheckingAccount cần tương đương với:
                    format("%s%n%s %s%n%.2f%n%d%n", accountNumber, firstName, lastName, balance,transactionCount);*/
            Formatter out = new Formatter(fileName);
            for(int i=0; i<listAccount.size(); i++) {
                if(listAccount.get(i).getAccountNumber().charAt(0)=='1')
                    out.format("%s%n%s %s%n%.2f%n%.3f%n", listAccount.get(i).getAccountNumber(), listAccount.get(i).getFirstName(), listAccount.get(i).getLastName(), listAccount.get(i).getBalance(), listAccount.get(i).getInterestRate());
                else
                    out.format("%s%n%s %s%n%.2f%n%d%n", listAccount.get(i).getAccountNumber(), listAccount.get(i).getFirstName(), listAccount.get(i).getLastName(), listAccount.get(i).getBalance(),listAccount.get(i).getTransactionCount());
            }
            out.close();
        } catch(IOException e){
            // In ra thông báo: "Cannot access file " + fileName + " to write!\n" + e.getMessage()
            System.out.println("Cannot access file " + fileName + " to write!\n" + e.getMessage());
        }
    }

    public static ArrayList<BankAccount> filterByBalance(ArrayList<BankAccount> listAccount, double upperBound, double lowerBound){
        ArrayList<BankAccount> results  = new ArrayList<BankAccount>();

        // Bổ sung mã lệnh để trả về danh sách các account có balance lớn hơn hoặc bằng
        // lowerBound và nhỏ hơn hoặc bằng upperBound (gồm cả 2 loại account)
        for (int i = 0; i < listAccount.size(); i++) {
            if (listAccount.get(i).getBalance() >= lowerBound && listAccount.get(i).getBalance() <= upperBound) {
                results.add(listAccount.get(i));
            }
        }
        return results;
    }

    public static BankAccount searchByAccountNumber(ArrayList<BankAccount> listAccount, String accountNum){
        BankAccount result  = null;

        // Bổ sung mã lệnh để tìm và trả về đối tượng trong danh sách listAccount có accountNumber trùng với accountNum.
        // Nếu không có trả về null.
        for (int i = 0; i < listAccount.size(); i++) {
            if (listAccount.get(i).getAccountNumber().equals(accountNum)) {
                result = listAccount.get(i);
            }
        }

        return result;
    }

    public static void main(String args[]){
        ArrayList<BankAccount> listAccount = readData("data.txt");
        // Không cần thay đổi phương thức main()!
    }
}
