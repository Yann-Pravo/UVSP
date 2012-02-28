package metier;

public class Cours {

    // Attributs
    private String code;
    private String lib;

    // Attributs d'association
    private Matiere mat;
    private TypeCours type;

    /**
     * Constructeur d'un objet Matiere prenant en compte le nom uniquement
     * @param lib Libellé de la matière
     */
    public Cours(String lib) {
        this.lib = lib;
    }

    /**
     * Constructeur d'un objet Matiere prenant en compte son code et son nom
     * @param code Code de la matière
     * @param lib Libellé de la matière
     */
    public Cours(String code, String lib) {
        this.code = code;
        this.lib = lib;
    }

    /**
     * Constructeur d'un objet Matiere prenant en compte son code et son nom
     * @param code Code de la matière
     * @param lib Libellé de la matière
     * @param u L'unité d'enseignement associé à la matière
     */
    public Cours(String code, String lib, Matiere mat) {
        this.code = code;
        this.lib = lib;
        this.mat = mat;
    }

    /**
     * Constructeur d'un objet Matiere prenant en compte son nom, sa description
     * et son coefficient
     * @param code Code de la matière
     * @param lib Libellé de la matière
     * @param u UE associé à la matiere
     * @param resp Responsable de la matiere
     */
    public Cours(String code, String lib, Matiere mat, TypeCours type)
    {
        this.code = code;
        this.lib = lib;
        this.mat = mat;
        this.type = type;
    }

    /**
     * Accesseur du code de m'objet Matiere
     * @return code de la matière
     */
    public String getCode() {
        return code;
    }

    /**
     * Modifieur du code de la matière
     * @param code Chaîne de caractères définissant le nouveau code de la matière
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * Accesseur de la matière d'un objet Cours
     * @return Matiere - Matiere de l'objet Cours
     */
    public Matiere getMatiere() {
        return mat;
    }

    /**
     * Modifieur du coefficient d'un objet Matiere
     * @param coeff Entier définissant le nouveau coefficient de l'objet Matiere
     */
    public void setMatiere(Matiere mat) {
        this.mat = mat;
    }

    /**
     * Accesseur du nom d'un objet Matiere
     * @return String - Nom de l'objet Matière
     */
    public String getLibelle() {
        return lib;
    }

    /**
     * Modifieur du nom d'un objet Matiere
     * @param nom Chaîne de caractères définissant le nouveau nom de l'objet Matiere
     */
    public void setLibelle(String lib) {
        this.lib = lib;
    }

    /**
     * Accesseur sur l'UE associées à un objet Matiere
     * @author Oph√©lie Mak
     * @return UE L'UE associés à une matière
     */
    public TypeCours getTypeCours() {
        return type;
    }

    /**
     * Modificateur de l'UE associée à un objet Matiere
     * @param u L'UE associée à une matière
     */
    public void setTypeCours(UE u) {
        this.type = type;
    }
}
