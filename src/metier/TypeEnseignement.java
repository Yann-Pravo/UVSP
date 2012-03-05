

package metier;

/** Classe métier permettant de gérer les types d'enseignement. 
 * @authors Ahardane Abdeslam, Balestrat Clément, Pravossoudovitch Yann
 * @version 1.0
 */
public class TypeEnseignement {
    //Attributs
    private String nom;                     //nom du type de l'enseignement
    private Double heureTypeEnseignement;   //nombre d'heure du type d'enseignement
    private Double heureEquivalentTD;       //nombre d'heure de TD equivalent

    /** Cette méthode permet l'instanciation d'un objet
     *  de la classe "TypeEnseignement". Il n'a qu'un seul paramètre.
     *  @param SNomTypeEns Le nom du nouveau type d'enseignement.
     */
    public TypeEnseignement(String SNomTypeEns) {
        this.nom = SNomTypeEns;
    }

    /** Cette méthode permet l'instanciation d'un objet de la classe
     *  "TypeEnseignement". Il a 2 paramètres.
     *  @param SNomTypeEns Le nom du nouveau type d'enseignement.
     *  @param DHeureTypeEns Le nombre d'heure du type d'enseignement.
     *  @param DHeureEqui Le nombre d'heure de TD équivalent.
     */
     public TypeEnseignement(String SNomTypeEns, Double DHeureTypeEns,
             Double DHeureEqui) {
         this.nom = SNomTypeEns;
         this.heureTypeEnseignement = DHeureTypeEns;
         this.heureEquivalentTD = DHeureEqui;
     }

     /** Cette méthode permet d'accéder à la valeur du champ
      *  "nom" d'un objet de la classe "TypeEnseignement".
      *  @return Renvoie une chaîne de caractères représentant le nom du type
      *  d'enseignement.
      */
      public String getNom() {
          return this.nom;
      }

      /** Cette méthode permet d'accéder à la valeur du champ
       *  "heureTypeEnseignement" d'un objet de la classe "TypeEnseignement".
       *  @return Renvoie un nombre réel représentant le nombre d'heure du type
       *  de l'enseignement.
       */
      public Double getheureTypeEnseignement() {
          return this.heureTypeEnseignement;
      }

      /** Cette méthode permet d'accéder à la valeur du champ "heureEquivalentTD
       *  d'un objet de la classe "TypeEnseignement".
       *  @return Renvoie le nombre d'heure de TD équivalent (nombre réel).
       */
      public Double getHeureEquiTD() {
          return this.heureEquivalentTD;
      }

      /** Cette méthode permet de modifier la valeur du champ "nom"
       *  d'un objet de la classe "TypeEnseignement".
       *  @param SNomTypeEns Le nouveau nom de type d'enseignement à modifier.
       */
      public void setNom(String SNomTypeEns) {
          this.nom = SNomTypeEns;
      }

      /** Cette méthode permet de modifier la valeur du champ
       *  "heureTypeEnseignement" d'un objet de la classe "TypeEnseignement".
       *  @param DHeureTypeEns Le nouveau nombre d'heures du type d'enseignement
       */
      public void setHeureTypeEnseignement(Double DHeureTypeEns) {
          this.heureTypeEnseignement = DHeureTypeEns;
      }

      /** Cette méthode permet de modifier la valeur du champ "heureEquivalentTD"
       *  d'un objet de la classe "TypeEnseignement".
       *  @param IHeureEquiTD Le nouveau nombre d'heure de TD équivalent.
       */
      public void setHeureEquiTD(Double IHeureEquiTD) {
          this.heureEquivalentTD = IHeureEquiTD;
      }

}
