package sistemaDeVendas;

public class Sale {
    private Product product;
    private int quantity;

    public Sale(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public double getTotal() {
        return product.getPrice() * quantity;
    }

    public String generateReportLine() {
        return product.getName() + " - " + this.quantity + " un - Total: R$ " + this.getTotal();
    }
}
