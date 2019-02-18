# kata-history
- Le projet History traite la journalisation des transactions ainsi que la consultation de l'historique.

(GET) http://localhost:8100/history : 
      Consulter l'historique de toutes les transactions effectuées, triées par date.
      
(GET) http://localhost:8100/history/{accountid} : 
      Consulter l'historique des transaction allant de ou vers le compte avec l'id {accountid}
