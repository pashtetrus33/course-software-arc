package ru.geekbrains.lesson4.task3;

class CustomerProvider {

    private Database database;

    public CustomerProvider(Database database) {
        this.database = database;
    }

    public Customer getCustomer(String login, String password) {
        for (Customer customer : database.getCustomers()) {
            if (customer.getLogin().equals(login) && customer.getPassword().equals(password)) {
                return customer;
            }
        }
        return null;
    }
}
