package designpattern.gof_templateMethod.sample02.dbtemplate;


import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class DBTemplate {

    public Object selectQuery(String sql){
        return execute(sql);
    }

    public List<Map> execute(String queryStatment){

        ResultSet resultSet = null;
        List<Map> resultList = null;
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {

            String[] connectionInfo = getDBInformation();

            connection = getConnection(connectionInfo);

            preparedStatement = executeStatement(connection, queryStatment);

            resultSet = getResultSet(preparedStatement);

            resultList = getResultMapRows(resultSet);

        }catch (Exception ex){
            ex.printStackTrace();
        }finally {
            try{
                if(connection != null ) releaseConnection(connection);
                if(preparedStatement != null ) releasePrepareStatement(preparedStatement);
                if(resultSet != null ) releaseResultSet(resultSet);
            }catch (Exception ex){
                ex.printStackTrace();
            }

        }

        return resultList;
    }

    /**
     * ResultSet을 Row마다 Map에 저장후 List에 다시 저장.
     * @param rs DB에서 가져온 ResultSet
     * @return Listt<map> 형태로 리턴
     * @throws Exception Collection
     */
    private List<Map> getResultMapRows(ResultSet rs) throws Exception
    {
        // ResultSet 의 MetaData를 가져온다.
        ResultSetMetaData metaData = rs.getMetaData();
        // ResultSet 의 Column의 갯수를 가져온다.
        int sizeOfColumn = metaData.getColumnCount();

        List<Map> list = new ArrayList<Map>();
        Map<String, Object> map;
        String column;
        // rs의 내용을 돌려준다.
        while (rs.next())
        {
            // 내부에서 map을 초기화
            map = new HashMap<String, Object>();
            // Column의 갯수만큼 회전
            for (int indexOfcolumn = 0; indexOfcolumn < sizeOfColumn; indexOfcolumn++)
            {
                column = metaData.getColumnName(indexOfcolumn + 1);
                // map에 값을 입력 map.put(columnName, columnName으로 getString)
                map.put(column, rs.getString(column));
            }
            // list에 저장
            list.add(map);
        }
        return list;
    }

    private void releaseConnection(Connection connection) throws SQLException {
        connection.close();
    }

    private void releaseResultSet(ResultSet resultSet) throws SQLException {
        resultSet.close();
    }

    private void releasePrepareStatement(PreparedStatement preparedStatement) throws SQLException {
        preparedStatement.close();
    }


    public abstract String[] getDBInformation();

    public abstract Connection getConnection(String[] connectionInfo) throws SQLException;

    public abstract PreparedStatement executeStatement(Connection connection, String sql) throws SQLException;

    public abstract ResultSet getResultSet(PreparedStatement preparedStatement) throws SQLException;

}
