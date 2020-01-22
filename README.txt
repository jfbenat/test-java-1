J'ai passé plus de 11 heures sur le sujet.
Ne souhaitant pas dépasser la journée de travail sur ces deux services, je m'arrête là.

Le reste à faire :

getAsJsonFormat() :

	les dates ne sont pas correctement désérializées ;
	par exemple dans le xml, la date date="2019-07-26" est considérée se caler à l'heure 00, 00 minutes...
	ainsi (du fait du fuseau horaire ?), la date reformattée dans le json devient "date":"25/07/2019"
	
	les montants débit crédit ne sont pas correctement reformattés :
	<amount>-800,10</amount> donne "debit":800.1,"credit":0.0
	au lieu de "debit": 800.10, "credit": 0
	
getAsSelfmedFormat() :

	je n'ai pas eu le temps de formatter les montants dans Selfmed output
	ni de convertir les status au travers d'un enum.
	
De plus, je n'ai pas eu le temps d'étudier la pertinence du coding d'interfaces et du pattern Strategy.
