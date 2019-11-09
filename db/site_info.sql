CREATE TABLE IF NOT EXISTS admins(
				  id_admin		INTEGER PRIMARY KEY AUTOINCREMENT
				, nom_admin		VARCHAR(20)
				, mdp_admin		VARCHAR(20)
				, join_admin	VARCHAR(10)
		);

	INSERT INTO admins(nom_admin, mdp_admin, join_admin)
			VALUES('admin', '97100109105110', '0000z9999');

CREATE TABLE IF NOT EXISTS membres(
				  id_membre					INTEGER PRIMARY KEY AUTOINCREMENT
				, prenom_membre				VARCHAR(20)
				, nom_membre				VARCHAR(20)
				, mdp_membre				VARCHAR(20)
				, nom_entreprise_membre		VARCHAR(50)
				, adresse_entreprise_membre	VARCHAR(100)
				, adresse_membre			VARCHAR(100)
				, codep_membre				VARCHAR(10)
				, ville_membre				VARCHAR(50)
				, region_membre				VARCHAR(50)
				, pays_membre				VARCHAR(20)
				, tel_membre				VARCHAR(20)
				, email_membre				VARCHAR(50)
				, secteur_membre			VARCHAR(100)
				, effectif_membre			VARCHAR(5)
				, offres_membre				VARCHAR(255)
				, statut_membre				VARCHAR(1)
				, join_membre				VARCHAR(5)
		);
		
CREATE TABLE IF NOT EXISTS offres(
				  id_offre				INTEGER PRIMARY KEY AUTOINCREMENT
				, titre_offre			VARCHAR(100)
				, entreprise_offre		VARCHAR(100)
				, date_offre			VARCHAR(20)
				, description_offre		VARCHAR(255)
				, ville_offre			VARCHAR(30)
				, region_offre			VARCHAR(50)
				, type_offre			VARCHAR(20)
				, experience_offre		VARCHAR(50)
				, formation_offre		VARCHAR(50)
				, langues_offre			VARCHAR(100)
				, permis_offre			VARCHAR(20)
				, bureautique_offre 	VARCHAR(255)
				, qualification_offre	VARCHAR(100)
				, salaire_offre			VARCHAR(20)
				, duree_offre			VARCHAR(20)
				, horaires_offre		VARCHAR(20)
				, deplacements_offre	VARCHAR(10)
				, join_offre			VARCHAR(10)
		);

CREATE TABLE IF NOT EXISTS documents(
				  id_document	INTEGER PRIMARY KEY AUTOINCREMENT
				, nom_document	VARCHAR(50)
				, type_document	VARCHAR(50)
				, join_document	VARCHAR(10)
		);