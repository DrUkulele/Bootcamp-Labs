package org.example;

public class Main {
    public static void main(String[] args) {
        UserInterface userInterface = new UserInterface();
        DealershipRepository dr = new DealershipRepository(args[0], args[1], args[2]);
        VehicleRepository vr = new VehicleRepository(args[0], args[1], args[2]);
        SalesContractRepository sr = new SalesContractRepository(args[0], args[1], args[2]);
        LeaseContractRepository lr = new LeaseContractRepository(args[0], args[1], args[2]);
        userInterface.userInterface(dr, vr, sr, lr);
    }
}