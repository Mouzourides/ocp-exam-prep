import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;;

class JDBC {

    // 4 interfaces:
    // - Driver: Get a connection to DB
    // - Connection: Communicate to DB
    // - Statement: Run sql statements on DB
    // - ResultSet: Results from SELECT statement

    public static void main(String args[]) throws SQLException {
        try (Connection con = DriverManager.getConnection("jdbc:sql://localhost:3306/db_name", "user", "password");
                Statement st = con.createStatement()) {

            // SCROLL TYPE
            // default scroll is scroll forward only ResultSet.TYPE_SCROLL_FORWARD_ONLY
            // Scroll type can be sensitive, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet
            // changes as data does

            // or insensitive, ResultSet.TYPE_SCROLL_INSENSITIVE, result set does not change
            // as data does

            // CONCURRENCY
            // Concurrency mode can be ResultSet.CONCUR_READ_ONLY: data can't be updated via
            // result set
            // or ResultSet.CONCUR_UPDATABLE data can be updated via result set
            Statement st2 = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

            // executeQuery(String) returns ResultSet and can only be for select statements,
            // can throw SQLException if not select statement
            ResultSet rs = st.executeQuery("SELECT * FROM users");

            // executeUpdate(String) returns int of rows affected, throws SQLException if
            // not
            // update, delete or insert statement
            int rows = st.executeUpdate("UPDATE SET username='Nik' WHERE id=667");

            // execute(String) returns boolean if resultSet or not
            String query = "SELECT username FROM users";
            boolean isResultSet = st.execute(query);
            if (isResultSet) {
                ResultSet resultSet = st.getResultSet();
            } else {
                int r = st.getUpdateCount();
            }

            // Getting data out of result set
            // rs.next() moves cursor to the next row, starts at 0
            // rs.next() returns true whilst theres data
            while (rs.next()) {

                // Can get data via column index
                // Index starts at 1...
                int id = rs.getInt(1);
                String name = rs.getString(2);

                // Can get data via specifying column name
                int id2 = rs.getInt("id");
                String name2 = rs.getString("username");

                // different get methods on ResultSet:
                // - getInt()
                // - getString()
                // - getDouble()
                // - getLong()
                // - getBoolean()
                // - getDate() -- old date api but can be converted to new
                // - getTime()
                // - getTimeStamp()
                // - getObject() -- can be cast into any object
            }

            // Scrolling the ResultSet
            rs.first(); // first row, returns boolean if data there
            rs.last(); // last row, returns boolean if data there

            rs.beforeFirst(); // before first row, no data here, returns void
            rs.afterLast(); // after last row, no data here, returns void

            rs.next(); // moves next row returns true if there's data
            rs.previous(); // moves previous row and returns true if there's data

            rs.absolute(1); // absolute position row 1, returns boolean if data there
            rs.absolute(-1); // minus number means count from bottom

            rs.relative(1); // moves cursor forward x amount relative to its current position, returns
                            // boolean if data there
            rs.relative(-1); // minus number moves backwards
        }
    }
}