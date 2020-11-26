package pojo;


/**
 *
 **/
public class Paper {
    private Integer id;
    private String name;
    private String author;
    private double price;
    private Integer sale;
    private Integer stock;

    @Override
    public String toString() {
        return "Paper{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", price=" + price +
                ", sale=" + sale +
                ", stock=" + stock +
                ", img_path='" + img_path + '\'' +
                '}';
    }


    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setSale(Integer sale) {
        this.sale = sale;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public void setImgPath(String img_path) {
        if(img_path!=null&& "".equals(img_path)){
            this.img_path=img_path;
        }
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public double getPrice() {
        return price;
    }

    public Integer getSale() {
        return sale;
    }

    public Integer getStock() {
        return stock;
    }

    public String getImg_path() {
        return img_path;
    }

    private String img_path="statics/img/seal.png";

    public Paper() {
    }

    public Paper(Integer id, String name, String author, double price, Integer sale, Integer stock, String img_path) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.price = price;
        this.sale = sale;
        this.stock = stock;
        this.img_path = img_path;
    }
}
