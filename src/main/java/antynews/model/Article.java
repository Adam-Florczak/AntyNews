package antynews.model;


import javax.persistence.*;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
@Table(name = "Article")
public class Article implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;
    @Column(name = "tittle")
    private String tittle;
    @Column (name = "content", length=1000000000)
    private String content;
    @Column(name = "date")
    private Date date;
    @Column(name = "img")
    private String img;


    @ManyToOne
    private Category category;



    public Article(String tittle, String content, Date date, Category category, String img) {
        this.tittle = tittle;
        this.content = content;
        this.date = date;
        this.category = category;
        this.img = img;
    }

    public Article() {
    }

    public static Date parseDate(String date) {
        try {
            return new SimpleDateFormat("yyyy-MM-dd").parse(date);
        } catch (ParseException e) {
            return null;
        }
    }

    public int getId() {
        return id;
    }

    public String getTittle() {
        return tittle;
    }

    public void setTittle(String tittle) {
        this.tittle = tittle;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }


    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    @Override
    public String toString() {
        return "Article{" +
                "id=" + id +
                ", tittle='" + tittle + '\'' +
                ", content='" + content + '\'' +
                ", date=" + date +
                ", img='" + img + '\'' +
                ", category=" + category +
                '}';
    }
}

