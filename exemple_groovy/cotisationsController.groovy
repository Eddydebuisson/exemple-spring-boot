@RestController
class CotisationsController {
@Autowired JdbcTemplate jdbcTemplate;
RowMapper<Cotisation> rowMapper = {rs,num -> return new Cotisation(
id:rs.getInt("id"),
libelle:rs.getString("libelle"),
code:rs.getString("code"),
tauxSalarial:rs.getString("tauxSalarial"),
tauxPatronal:rs.getString("tauxPatronal")
)}
@RequestMapping("/")
List<Cotisation> lister() {
return this.jdbcTemplate.query("select * from COTISATION", rowMapper)
}
}