import java.util.Scanner;
class pigeonService{
	
    static Scanner input = new Scanner(System.in);
    static String userName = "rashmika";
    static String password = "123";
    static String[][] supliers = {};
    static String[] categories = {}; 
    static String[][] itemManage = {};

    private static void clearConsole() {
    final String os = System.getProperty("os.name");
    try {
        if (os.equals("Linux")) {
            System.out.print("\033\143");
        } else if (os.startsWith("Windows")) {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } else {
            System.out.print("\033[H\033[2J");
            System.out.flush();
        }
    } catch (final Exception e) {
        System.err.println(e.getMessage());
    }
}

    public static void grow1(){
		String[] temp = new String[categories.length+1];
		for (int i = 0; i < categories.length ; i++){
			temp[i] = categories[i];
		}
		
		categories = temp;
	}
    
    public static String[][] grow(String[][] ar , int x){
		String[][] temp = new  String[ar.length + 1][x];
		
		for (int i = 0; i < ar.length; i++){
			for (int j = 0; j < x; j++){
				temp[i][j] = ar[i][j];
			}	
		}
		return temp;
	} 
    
    public static void loginPage(){
        System.out.println("+--------------------------------------------------------------------+");
        System.out.println("|                            LOGIN PAGE                              |");
        System.out.println("+--------------------------------------------------------------------+");

        do {
            System.out.print("\nUser Name : ");
            String uN = input.next();
            if (userName.equals(uN)) {
                break;
            } else {
                System.out.println("User name is invalid. Please try again!");
            }
        } while (true);

        do {
            System.out.print("\nPassword : ");
            String pW = input.next();
            if (password.equals(pW)) {
                break;
            } else {
                System.out.println("Password is invalid. Please try again!");
            }
        } while (true);
        clearConsole();
    }

    public static void credentialManage(){
        System.out.println("+--------------------------------------------------------------------+");
        System.out.println("|                         CREDENTIAL MANAGE                          |");
        System.out.println("+--------------------------------------------------------------------+");

        do {
            System.out.print("\nPlease enter the user name to verify it's you: ");
            String uN = input.next();
            if (userName.equals(uN)) {
                System.out.println("Hey " + userName);
                break;
            } else {
                System.out.println("Invalid user name. Try again!");
            }
        } while (true);

        do {
            System.out.print("Enter your current password: ");
            String pW = input.next();
            if (password.equals(pW)) {
                break;
            } else {
                System.out.println("Incorrect password. Try again!");
            }
        } while (true);

        System.out.println();
        System.out.print("Enter your new password: ");
        password = input.next();

        System.out.print("Password changed successfully! Do you want to go to the home page (Y/N)");

        do {
            char want = input.next().charAt(0);
            if (want == 'y'|| want == 'Y') {
                clearConsole();
                return;
            } else if (want == 'n'|| want == 'N') {
                clearConsole();
                System.exit(0);
            } else {
                System.out.print("Wrong input!!! Try again, Do you want to go to the home page (Y/N)");
            }
        } while (true);
    }
    
    public static void addSupplier(){
	
		while(true){
			
		System.out.println("+--------------------------------------------------------------------+");
        System.out.println("|                         ADD SUPPLIER                               |");
        System.out.println("+--------------------------------------------------------------------+");				
		
				
        String id;
      do{
			boolean exit = false;
			System.out.print("\nSupplier ID   : ");
			id = input.next();
			for (int i = 0; i < supliers.length ; i++){
				if(supliers[i][0].equals(id)){
					System.out.println("already exists. try another supplier id!");
		    		exit = true;
					break;
				}						
			}
			if(!exit){
				break;
			}
			
		 }while (true);
		
        System.out.print("Supplier Name : ");
        String name = input.next();
        
		supliers =  grow(supliers, 2);  /* me method eken wenne api hadapu arry eke length ek 0 nisa me step ek lagata code ek
					run unoth grow() kiyla wena method ekk magin api hdpu arry eke length ek 1 kin grow 
					grow kara ganimai  */
				
		
		supliers[supliers.length-1][0] = id;
		supliers[supliers.length-1][1] = name;
		
		System.out.print("add successfully! Do you want to add another supplier(Y/N)?");
		
		while(true){   // me while loop eken wenne wrong input ekk dunnuth eka manage kirimata
		char want = input.next().charAt(0);
		
		if(want == 'n'|| want == 'N'){                 
			clearConsole();                      
			return;
		}else if(want == 'y'|| want == 'Y'){
			clearConsole();
			break;	
		}else{
			System.out.print("wrong input. try again, Do you want to add another supplier(Y/N)?");
			
		}			
				
		}
		
		} 	
	}
	
	public static void updateSupplier(){
		
		while(true){
		
		System.out.println("+--------------------------------------------------------------------+");
        System.out.println("|                        UPDATE SUPPLIER                             |");
        System.out.println("+--------------------------------------------------------------------+");		
		
		String id;
		int index;
		
	L1:	while(true){
		
		System.out.print("\nSupplier ID   : ");
		id = input.next();		
		
		for (int i = 0; i < supliers.length ; i++){
			if (supliers[i][0].equals(id)){
				System.out.println("Supplier Name   : "+supliers[i][1]);
				index = i;
				break L1;
			}	
		}
		System.out.println("can't find supplier id. try again!");
		}
		
		System.out.print("\nEnter the new supplier name : ");
		supliers[index][1] = input.next();
		
		
		System.out.print("Update Successfully! Do you want to update another supplier?(Y/N)");
		
		while(true){
		
		char want = input.next().charAt(0);
		
		if(want == 'y'|| want == 'Y'){
			clearConsole();
			break;
		}else if(want == 'n'|| want == 'N'){
			clearConsole();
			return;
		}else{
			System.out.print("wrong input. try again, Do you want to update another supplier?(Y/n)");
		}
		}
	    }	
	}
	
	public static void deleteSup(int x){
		
		// me method eken wenne api haduwa array ekata
		
		String[][] temp = new String[supliers.length - 1][2];
		
		for(int i = 0, j = 0; i < supliers.length; i++){
			if(i == x){
				continue;
			}else{
				temp[j][0] = supliers[i][0];
				temp[j][1] = supliers[i][1];
				j++;				
			}
		}
		supliers = temp;	
	}
	
	public static void deleteSupplier(){
		
		while(true){
		
		System.out.println("+--------------------------------------------------------------------+");
        System.out.println("|                        DELETE SUPPLIER                             |");
        System.out.println("+--------------------------------------------------------------------+");			
		
		String id;
		
	L1:	while(true){
		
		System.out.print("\nSupplier ID   : ");
		id = input.next();
		
		for (int i = 0; i < supliers.length ; i++){
			if (supliers[i][0].equals(id)){
				deleteSup(i);
				break L1;
			}
		}
		System.out.println("can't find supplier id. try again!");	
	    }
	    System.out.print("deleted Successfully! Do you want to delete another supplier?(Y/N)");
		
		while(true){
		char want = input.next().charAt(0);
		
		if(want == 'y'|| want == 'Y'){
			clearConsole();
			break;
		}else if(want == 'n'|| want == 'N'){
			clearConsole();
			return;
		}else{
			System.out.print("wrong input. try again, Do you want to delete another supplier?(Y/N)");
		}
		}
			    
	    }
	}
	
	public static void searchSupplier(){

		while(true){
		
		System.out.println("+--------------------------------------------------------------------+");
        System.out.println("|                        SEARCH SUPPLIER                             |");
        System.out.println("+--------------------------------------------------------------------+");		
		
		String id;
		int index;
		
	L1:	while(true){
		
		System.out.print("\nSupplier ID   : ");
		id = input.next();		
		
		for (int i = 0; i < supliers.length ; i++){
			if (supliers[i][0].equals(id)){
				System.out.println("Supplier Name   : "+supliers[i][1]);
				index = i;
				break L1;
			}	
		}
		System.out.println("can't find supplier id. try again!");
		}
		
		System.out.print("searched Successfully! Do you want to search another supplier?(Y/N)");
		
		while(true){
		
		char want = input.next().charAt(0);
		
		if(want == 'y'|| want == 'Y'){
			clearConsole();
			break;
		}else if(want == 'n'|| want == 'N'){
			clearConsole();
			return;
		}else{
			System.out.print("wrong input. try again, Do you want to update another supplier?(Y/n)");
		}
		}
	  }	
	}
	
	public static void viewSupplier(){
		
	  System.out.println("+--------------------------------------------------------------------+");
      System.out.println("|                          VIEW SUPPLIER                             |");
      System.out.println("+--------------------------------------------------------------------+");
        
      System.out.println();
        		
			System.out.printf("+---------------------+-----------------------+%n");
			System.out.printf("|%16s     |%18s     |%n","SUPPLIER ID", "SUPPLIER NAME");
			System.out.printf("+---------------------+-----------------------+%n");
		for (int i = 0; i < supliers.length ; i++){
			
			System.out.printf("|%12s         |%18s     |%n",supliers[i][0],supliers[i][1]);
	
		}
			System.out.printf("+---------------------+-----------------------+");
		
		System.out.print("\nDo you want to go supplier manage page(Y/N)?");
		
		while(true){
		char want = input.next().charAt(0);
		if(want=='y'|| want == 'Y'){
			clearConsole();
			return;
		}else if(want=='n'|| want == 'N'){
			clearConsole();
			System.exit(0);
		}else{
			System.out.print("Wrong input!!! Try again, Do you want to go to supplier manage page(Y/N)");
		}
		}
	 }
	
    public static void supplierManage(){
		System.out.println("+--------------------------------------------------------------------+");
        System.out.println("|                        SUPPLIER MANAGE                             |");
        System.out.println("+--------------------------------------------------------------------+");

        System.out.println("\n[1] Add Supplier\t\t[2] Update Supplier ");
        System.out.println("[3] Delete Supplier\t\t[4] View Suppliers ");
        System.out.println("[5] Search Supplier\t\t[6] Home Page");
        System.out.print("\nEnter an option to continue > ");
        int option = input.nextInt();
        
        switch (option) {
            case 1:
				clearConsole();
                addSupplier();
                supplierManage();
                break;
            case 2:
				clearConsole();
                updateSupplier();
                supplierManage();
                break;
            case 3:
				clearConsole();
                deleteSupplier();
                supplierManage();
                break;
            case 4:
                clearConsole();
                viewSupplier();
                supplierManage();
                break;
            case 5:
                clearConsole();
                searchSupplier();
                supplierManage();
                break;
            case 6:
				clearConsole();
                return;
                
        }    
	}
	
	public static void addNewItemCategory(){
	
		while(true){
			
				System.out.println("+--------------------------------------------------------------------+");
        System.out.println("|                       ADD ITEM CATEGORY                            |");
        System.out.println("+--------------------------------------------------------------------+");				
				
        String cg;
		while(true){
			boolean exit = false;
			System.out.print("\nEnter the new item category: ");
			cg = input.next();
			for (int i = 0; i < categories.length ; i++){
				if(categories[i].equals(cg)){
					System.out.println("already exists. try another category!");
					exit = true;
					break;
				}
			}
			if(!exit){
				break;
			}		
		}
		
		grow1();  
				
		categories[categories.length-1] = cg; 
		
		System.out.print("add successfully! Do you want to add another category(Y/N)?");
		
		while(true){   // me while loop eken wenne wrong input ekk dunnuth eka manage kirimata
		char want = input.next().charAt(0);
		
		if(want== 'n'|| want == 'N'){                 
			clearConsole();                      
			return;
		}else if(want == 'y'|| want == 'Y'){
			clearConsole();
			break;	
		}else{
			System.out.print("wrong input. try again, Do you want to add another supplier(Y/N)?");	
		}					
		}
		} 	
	}
	
	public static void deleteCg(int y){
		String[] temp = new String[categories.length-1];
		
		for (int i = 0,j = 0; i < categories.length ; i++){
			if(i==y){
				continue;
			}else{
				temp[j] = categories[i];
				j++;
			}
		}
			
	}
	
	public static void deleteItemCategory(){
	
		while(true){
			
		System.out.println("+--------------------------------------------------------------------+");
        System.out.println("|                       DELETE ITEM CATEGORY                         |");
        System.out.println("+--------------------------------------------------------------------+");				
				
        String cg;
	L3:	while(true){
			System.out.print("\nEnter the delete item category: ");
			cg = input.next();
			for (int i = 0; i < categories.length ; i++){
				if(categories[i].equals(cg)){
					deleteCg(i);
					break L3;
				}
			}
			System.out.println("can't find item category. try again!");			
		}
		System.out.print("deleted Successfully! Do you want to delete another item category(Y/N)?");
		
		while(true){   // me while loop eken wenne wrong input ekk dunnuth eka manage kirimata
		char want = input.next().charAt(0);
		
		if(want== 'n'|| want == 'N'){                 
			clearConsole();                      
			return;
		}else if(want == 'y'|| want == 'Y'){
			clearConsole();
			break;	
		}else{
			System.out.print("wrong input. try again, Do you want to delete another item category(Y/N)?");
			
		}					
		}
		} 	
	}
	
	public static void UpdateItemCategory(){
		while(true){
			
				System.out.println("+--------------------------------------------------------------------+");
        System.out.println("|                       UPDATE ITEM CATEGORY                            |");
        System.out.println("+--------------------------------------------------------------------+");				
				
        String cg;
	L3:	while(true){
			System.out.print("\nEnter the update item category: ");
			cg = input.next();
			for (int i = 0; i < categories.length ; i++){
				if(categories[i].equals(cg)){
					System.out.print("\nEnter the new item category: ");
					categories[i] = input.next();
					break L3;
				}
			}
			System.out.println("can't find item category. try again!");			
		}
		System.out.print("updated Successfully! Do you want to update another item category(Y/N)?");
		
		while(true){   // me while loop eken wenne wrong input ekk dunnuth eka manage kirimata
		char want = input.next().charAt(0);
		
		if(want== 'n'|| want == 'N'){                 
			clearConsole();                      
			return;
		}else if(want == 'y'|| want == 'Y'){
			clearConsole();
			break;	
		}else{
			System.out.print("wrong input. try again, Do you want to update another item category(Y/N)?");
			
		}					
		}
		} 			
	}
	
	public static void ManageItemCategories(){
		System.out.println("+--------------------------------------------------------------------+");
        System.out.println("|                       MANAGE ITEM CATEGORY                         |");
        System.out.println("+--------------------------------------------------------------------+");

        System.out.println("\n[1] Add New Item Category\t\t[2] Delete Item Category ");
        System.out.println("[3] Update Item Category\t\t[4] Stock Management ");
        System.out.print("\nEnter an option to continue > ");
        int option = input.nextInt();
        
        switch (option) {
            case 1:
				clearConsole();
                addNewItemCategory();
                ManageItemCategories();
                break;
            case 2:
				clearConsole();
                deleteItemCategory();
                ManageItemCategories();
                break;
            case 3:
				clearConsole();
                UpdateItemCategory();
                ManageItemCategories();
                break;
            case 4:
                clearConsole();
                return;              
        }    
	}
		
	public static void addItemMenuBar(){
			System.out.println("+--------------------------------------------------------------------+");
			System.out.println("|                           ADD ITEM                                 |");
			System.out.println("+--------------------------------------------------------------------+");				
		}
		
	public static void addItem(){
			
		while(true){
			
		addItemMenuBar();

		String temp;
		while(true){
		boolean exit = false;
		System.out.print("\nItem Code   :");
		temp = input.next();
		for(int i = 0; i < itemManage.length; i++){
				if(itemManage[i][0].equals(temp)){
					System.out.println("already exists. try another itemCode");
					exit = true;	
				}
		}
		if(!exit){
			break;
		}
		}
		
		itemManage = grow(itemManage,6);
		
		itemManage[itemManage.length-1][0] = temp;
		
		System.out.println("\nSupplier list:");
		System.out.printf("+----------+---------------------+-----------------------+%n");
		System.out.printf("|%5s     |%16s     |%18s     |%n","#","SUPPLIER ID", "SUPPLIER NAME");
		System.out.printf("+----------+---------------------+-----------------------+%n");
		for (int i = 0; i < supliers.length ; i++){
		System.out.printf("|%5d     |%12s         |%18s     |%n",(i+1),supliers[i][0],supliers[i][1]);
		}
		System.out.printf("+----------+---------------------+-----------------------+%n");	
		
		System.out.print("\nEnter the supplier number >");
		int ic = input.nextInt();
		if(ic <= supliers.length){
			itemManage[itemManage.length-1][1] = supliers[ic-1][0];
		}
		
		
		
		System.out.println("\nItem Categories:");
		System.out.printf("+----------+-----------------------+%n");
		System.out.printf("|%5s     |%18s     |%n","#","CATEGORY NAME");
		System.out.printf("+----------+-----------------------+%n");
		for (int i = 0; i < categories.length; i++){
		System.out.printf("|%5d     |%13s          |%n",(i+1),categories[i]);
		}
		System.out.printf("+----------+-----------------------+%n");
		
		System.out.print("\nEnter the category number >");
		int cn = input.nextInt();
		itemManage[itemManage.length-1][2] = categories[cn-1];   
		
		
		System.out.print("\nDescription  :");
		itemManage[itemManage.length-1][3] = input.next();
		
		System.out.print("Unit price   :");
		itemManage[itemManage.length-1][4] = input.next();
		
		System.out.print("Qty on hand  :");
		itemManage[itemManage.length-1][5] = input.next();
		
		System.out.print("add successfully! Do you want to add another Item(Y/N)?");
		
		while(true){
		char want = input.next().charAt(0);
		if(want == 'y'|| want == 'Y'){
			clearConsole();
			break;
		}else if(want == 'n'|| want == 'N'){
			clearConsole();
			return;
		}else{
			System.out.print("wrong input. try again, Do you want to add another Item(Y/N)?");
		}
		}
		}
	}
		
	public static void AddItemCustomize(){
		
		addItemMenuBar();

		if(categories.length == 0){
			
			System.out.println("\nOOPS! It seems that you dont't have any item categories in the system.");
			System.out.print("Do you want to add a new item category(Y/N)?");
			
			while(true){
			char want = input.next().charAt(0);
			if(want == 'y' || want == 'Y'){
				clearConsole();
				addNewItemCategory();
				break;
			}else if(want == 'n' || want == 'N'){
				clearConsole();
				return;
			}else{
				System.out.print("wrong input. try again, Do you want to add a new item category(Y/N)?");
			}
		  }
		}
		
		clearConsole();
		addItemMenuBar();
			
		if(supliers.length == 0){

			System.out.println("\nOOPS! It seems that you dont't have any suppliers in the system.");
			System.out.print("Do you want to add a new supplier(Y/N)?");
			
			while(true){
			char want = input.next().charAt(0);
			if(want == 'y' || want == 'Y'){
				clearConsole();
				addSupplier();
				break;
			}else if(want == 'n' || want == 'N'){
				clearConsole();
				return;
			}else{
				System.out.print("wrong input. try again, Do you want to add a new supplier(Y/N)?");
			}
		  }
			
		}
		
			clearConsole(); 
			addItem();
	
		}
		
	public static void GetItemSupplierWish(){
			
			while(true){
			System.out.println("+--------------------------------------------------------------------+");
			System.out.println("|                         SEARCH SUPPLIER                            |");
			System.out.println("+--------------------------------------------------------------------+");	
			
			String id;
			System.out.print("\nEnter Supplier Id: ");
			
		L1:	while(true){
			id	= input.next();
			for (int i = 0; i < supliers.length ; i++){
				if(supliers[i][0].equals(id)){
					System.out.println(supliers[i][1]);	
					break L1;
				}			
			}
			System.out.print("Cant't find.Enter another Supplier Id: ");
			} 
			
			System.out.printf("+-------------+---------------+--------------+---------------+------------+%n");
			System.out.printf("|%11S  |%13S  |%12S  |%13S  |%10S  |%n","ITEM CODE","DESCRIPTION","UNIT PRICE","QTY ON HAND","CATEGORY");
			System.out.printf("+-------------+---------------+--------------+---------------+------------+%n");
			for (int i = 0; i < itemManage.length ; i++){
					if(itemManage[i][1].equals(id)){
							System.out.printf("|%9s    |%10s     |%10s    |%10s     |%9s   |%n",itemManage[i][0],itemManage[i][3],itemManage[i][4],itemManage[i][5],itemManage[i][2]);
					}
			}
			System.out.printf("+-------------+---------------+--------------+---------------+------------+%n");
			
			System.out.print("search successfully! Do you want to another search(Y/N)?");
			while(true){
			char want = input.next().charAt(0);
			if(want == 'y' || want == 'Y'){
				clearConsole();
				break;
			}else if(want == 'n' || want == 'N'){
				clearConsole();
				return;
			}else{
				System.out.print("wrong input. try again, Do you want to another search(Y/N)?");
			}
			}
			}	
							
		}
		
	public static void ViewItem(){

	  System.out.println("+--------------------------------------------------------------------+");
      System.out.println("|                           VIEW ITEMS                               |");
      System.out.println("+--------------------------------------------------------------------+");
		
			for (int i = 0; i < categories.length ; i++){
				System.out.println(categories[i]+":");
				
				System.out.printf("+----------+----------+-------------+-----------+----------+%n");
				System.out.printf("|%7s   |%7s   |%10s   |%8s   |%7s   |%n","SID","CODE","DESC","PRICE","QTY");
				System.out.printf("+----------+----------+-------------+-----------+----------+%n");
				for (int j = 0; j < itemManage.length ; j++){
						if(categories[i].equals(itemManage[j][2])){
						System.out.printf("|%7s   |%7s   |%10s   |%8s   |%7s   |%n",itemManage[j][1], itemManage[j][0], itemManage[j][3], itemManage[j][4], itemManage[j][5]);	
						}
				}
				System.out.printf("+----------+----------+-------------+-----------+----------+%n");
			}
			
			System.out.print("\nsearched successfully! Do you want to go to the stock management page(Y/N)?");
			char want = input.next().charAt(0);
			
			if(want == 'y' || want == 'Y'){
				clearConsole();
				return;
			}else{
				clearConsole();
				System.exit(0);
			}
			
		}
		
	public static double[] sortArray(double[] xr){

			for (int i = 0; i < xr.length - 1 ; i++){
					for (int j = 0; j < xr.length - 1; j++){
							if(xr[j]>xr[j+1]){
									double temp1 = xr[j];
									xr[j] = xr[j+1];
									xr[j+1] = temp1;
							}
					}	
			}
			return xr;	
		}
		
	public static void RankItemPerUnitPrice(){

	  System.out.println("+--------------------------------------------------------------------+");
      System.out.println("|                        RANKED UNIT PRICE                           |");
      System.out.println("+--------------------------------------------------------------------+");			
			
		double[] uPrice = new double[itemManage.length];  /* unitPrice tika double wlt conver krl venama array ekkt 
															 daganna thama me arrya eka haduwe  */
		for(int i = 0; i < itemManage.length ; i++){
			double num1 = Double.parseDouble(itemManage[i][4]);
			uPrice[i] = num1;
		}
			
		uPrice =  sortArray(uPrice);  // uPrice array ek sort kara ganna sortArray method ekt call krnw
				
			
			System.out.printf("+---------+----------+-------------+------------+---------+------------+%n");	
			System.out.printf("|%6s   |%7s   |%9s    |%8s    |%6s   |%9s   |%n","SID","CODE","DESC","PRICE","QTY","CAT");	
			System.out.printf("+---------+----------+-------------+------------+---------+------------+%n");
			for (int i = 0; i < itemManage.length ; i++){
					for (int j = 0; j < itemManage.length ; j++){
							if(uPrice[i] == Double.parseDouble(itemManage[j][4])){
								System.out.printf("|%6s   |%7s   |%9s    |%8s    |%6s   |%9s   |%n",itemManage[j][1],itemManage[j][0],itemManage[j][3],itemManage[j][4],itemManage[j][5],itemManage[j][2]);
							}
					}
			}
			
			System.out.printf("+---------+----------+-------------+------------+---------+------------+%n");
			
			System.out.print("Do you want to go to stock manage page?(Y/N)");
			
			while(true){
			char want = input.next().charAt(0);
			if(want == 'y' || want == 'Y'){
					clearConsole();
					return;
			}else if(want == 'n' || want == 'N'){
					clearConsole();
					System.exit(0);
			}else{
					System.out.print("wrong input. try again, Do you want to go to stock manage page?(Y/N)");
			}
			}
			
			
		}
		
	public static void stokManage(){
		System.out.println("+--------------------------------------------------------------------+");
        System.out.println("|                        STOCK MANAGEMENT                            |");
        System.out.println("+--------------------------------------------------------------------+");

        System.out.println("\n[1] Manage Item Categories\t\t[2] Add Item ");
        System.out.println("[3] Get Item Supplier Wish\t\t[4] View Item ");
        System.out.println("[5] Rank Item Per Unit price\t\t[6] Home Page");
        System.out.print("\nEnter an option to continue > ");
        int option = input.nextInt();
        
        switch (option) {
            case 1:
				clearConsole();
                ManageItemCategories();
                stokManage();
                break;
            case 2:
				clearConsole();
                AddItemCustomize();
                stokManage();
                break;
            case 3:
				clearConsole();
                GetItemSupplierWish();
                stokManage();
                break;
            case 4:
                clearConsole();
				ViewItem();
                stokManage();
                break;
            case 5:
                clearConsole();
				RankItemPerUnitPrice();
                stokManage();
                break;
            case 6:
				clearConsole();
                return;
                
        }    
	}
	
    public static void homePage() {
        System.out.println("+--------------------------------------------------------------------+");
        System.out.println("|             WELCOME TO IJSE STOCK MANAGEMENT SYSTEM                |");
        System.out.println("+--------------------------------------------------------------------+");

        System.out.println("\n[1] Change the Credentials\t[2] Supplier Manage ");
        System.out.println("[3] Stock Manage\t\t[4] Log out ");
        System.out.println("[5] Exit the system ");
        System.out.print("\nEnter an option to continue > ");
        int option = input.nextInt();
		
		switch (option) {
            case 1:
                clearConsole();
                credentialManage();
                homePage();
                break;
            case 2:
				clearConsole();
                supplierManage();
                homePage();
                break;
            case 3:
				clearConsole();
                stokManage();
                homePage();
                break;
            case 4:
                clearConsole();
                break;
            case 5:
                clearConsole();
                System.exit(0);  // Exit the system.

                
        }   
	}

    public static void main(String[] args) {
		while(true){
			loginPage();
			homePage(); 
		   
		}	
    } 
      
}
