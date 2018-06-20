package antynews.model;

import org.hibernate.dialect.MySQL5InnoDBDialect;

public class CustomMySqlDialect extends MySQL5InnoDBDialect {

    @Override
    public String getTableTypeString() {
        return " ENGINE=InnoDB DEFAULT CHARSET=utf8";
    }
}
