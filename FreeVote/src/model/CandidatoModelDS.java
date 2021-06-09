package model;

    import java.sql.Connection;
    import java.sql.PreparedStatement;
    import java.sql.ResultSet;
    import java.sql.SQLException;
    import java.util.Collection;
    import java.util.LinkedList;
    
    import javax.sql.DataSource;
    
    public class CandidatoModelDS implements Model<CandidatoBean>{
        
        private DataSource ds = null;
    
        public CandidatoModelDS(DataSource ds) {
            this.ds = ds;
        }
    
        public CandidatoBean doRetrieveByKey(String id) throws SQLException {
            Connection connection = null;
            PreparedStatement preparedStatement = null;
    
            CandidatoBean bean = new CandidatoBean();
    
            String selectSQL = "SELECT * FROM candidato WHERE codice_fiscale = ?";
    
            try {
                connection = ds.getConnection();
                preparedStatement = connection.prepareStatement(selectSQL);
                preparedStatement.setString(1, id);
    
                ResultSet rs = preparedStatement.executeQuery();
    
                while (rs.next()) {
                    bean.setCf(rs.getString("codice_fiscale"));
                    bean.setNome(rs.getString("nome"));
                    bean.setCognome(rs.getString("cognome"));
                    bean.setPartito(rs.getString("partito"));
                    //bean.setFoto(rs.getBlob("foto")); 
                    bean.setCurriculum(rs.getString("curriculum"));
                }
    
            } finally {
                try {
                    if (preparedStatement != null)
                        preparedStatement.close();
                } finally {
                    if (connection != null) {
                        connection.close();
                    }
                }
            }
    
            return bean;
        }
    
        public Collection<CandidatoBean> doRetrieveAll(String order) throws SQLException {
            Connection connection = null;
            PreparedStatement preparedStatement = null;
    
            Collection<CandidatoBean> candidati = new LinkedList<CandidatoBean>();
    
            String selectSQL = "SELECT * FROM candidato";
    
            if (order != null && !order.equals("") && ((order == "codice_fiscale") || (order == "nome") || (order == "cognome") || (order == "partito") || (order == "foto") || (order == "curriculum"))) { //???
                selectSQL += " ORDER BY " + order;
            }
    
            try {
                connection = ds.getConnection();
                preparedStatement = connection.prepareStatement(selectSQL);
    
                ResultSet rs = preparedStatement.executeQuery();
    
                while (rs.next()) {
                    CandidatoBean bean = new CandidatoBean();
    
                    bean.setCf(rs.getString("codice_fiscale"));
                    bean.setNome(rs.getString("nome"));
                    bean.setCognome(rs.getString("cognome"));
                    bean.setPartito(rs.getString("partito"));
                    //bean.setFoto(rs.getBlob("foto")); 
                    bean.setCurriculum(rs.getString("curriculum")); 
    
                    candidati.add(bean);
                }
            } finally {
                try {
                    if (preparedStatement != null)
                        preparedStatement.close();
                } finally {
                    if (connection != null) {
                        connection.close();
                    }
                }
            }
    
            return candidati; 
        }
    
        public void doSave(CandidatoBean candidato) throws SQLException {
            Connection connection = null;
            PreparedStatement preparedStatement = null;
    
            String insertSQL = "INSERT INTO Candidato (codice_fiscale,nome,cognome,curriculum,foto,partito) VALUES (?, ?, ?, ?, ?, ?,?)";
    
            try {
                connection = ds.getConnection();
                connection.setAutoCommit(false);
                preparedStatement = connection.prepareStatement(insertSQL);
    
                preparedStatement.setString(1, candidato.getCf());
			    preparedStatement.setString(2, candidato.getNome());
                preparedStatement.setString(3, candidato.getCognome());
                preparedStatement.setString(4, candidato.getCurriculum());
                //preparedStatement.setBlob(5, candidato.getFoto());
                preparedStatement.setString(6, candidato.getPartito());
                
                preparedStatement.executeUpdate();
    
                connection.commit();
    
            } finally {
                try {
                    if (preparedStatement != null)
                        preparedStatement.close();
                } finally {
                    if (connection != null) {
                        connection.close();
                    }
                }
            }
        }
    
        public void doUpdate(CandidatoBean candidato) throws SQLException {
            Connection connection = null;
            PreparedStatement preparedStatement = null;
    
            String updateSQL = "UPDATE candidato SET nome = ?, cognome = ?, partito = ?, foto = ?, curriculum =? WHERE codice_fiscale = ?";
    
            try {
                connection = ds.getConnection();
                connection.setAutoCommit(false);
                preparedStatement = connection.prepareStatement(updateSQL);
    
                preparedStatement.setString(1, candidato.getNome());
                preparedStatement.setString(2, candidato.getCognome());
                preparedStatement.setString(3, candidato.getPartito());			
                //preparedStatement.setBlob(4, candidato.getFoto());
                preparedStatement.setString(5, candidato.getCurriculum());
                preparedStatement.setString(6, candidato.getCf());
    
                preparedStatement.executeUpdate();
                connection.commit();
    
            } finally {
                try {
                    if (preparedStatement != null)
                        preparedStatement.close();
                } finally {
                    if (connection != null) {
                        connection.close();
                    }
                }
            }
        }
    
        @Override
        public void doDelete(CandidatoBean candidato) throws SQLException {
            Connection connection = null;
            PreparedStatement preparedStatement = null;
    
            String deleteSQL = "DELETE FROM candidato WHERE codice_fiscale = ?";
    
            try {
                connection = ds.getConnection();
                connection.setAutoCommit(false);
                preparedStatement = connection.prepareStatement(deleteSQL);
                preparedStatement.setString(1, candidato.getCf());
    
                preparedStatement.executeUpdate();
    
                connection.commit();
    
            } finally {
                try {
                    if (preparedStatement != null)
                        preparedStatement.close();
                } finally {
                    if (connection != null) {
                        connection.close();
                    }
                }
            }
        }
    
    
    public Collection<CandidatoBean> doRetrieveByPartito(String partito, String order) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        Collection<CandidatoBean> candidati = new LinkedList<CandidatoBean>();

        String selectSQL = "SELECT * FROM candidato WHERE partito = ?";

        if (order != null && !order.equals("") && ((order == "codice_fiscale") || (order == "nome") || (order == "cognome") || (order == "partito") || (order == "foto") || (order == "curriculum"))) { //???
            selectSQL += " ORDER BY " + order;
        }

        try {
            connection = ds.getConnection();
            preparedStatement = connection.prepareStatement(selectSQL);
            preparedStatement.setString(1,partito);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                CandidatoBean bean = new CandidatoBean();

                bean.setCf(rs.getString("codice_fiscale"));
                bean.setNome(rs.getString("nome"));
                bean.setCognome(rs.getString("cognome"));
                bean.setPartito(rs.getString("partito"));
                //bean.setFoto(rs.getBlob("foto")); 
                bean.setCurriculum(rs.getString("curriculum")); 

                candidati.add(bean);
            }
        } finally {
            try {
                if (preparedStatement != null)
                    preparedStatement.close();
            } finally {
                if (connection != null) {
                    connection.close();
                }
            }
        }

        return candidati; 
    }

}
