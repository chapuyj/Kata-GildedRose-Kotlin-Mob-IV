# Spécification de la Rose dorée (Gilded Rose)

Bonjour et bienvenue dans l'équipe de la Rose dorée.

Comme vous le savez, notre petite taverne située à proximité d'une cité importante est dirigée par l'amicale aubergiste Allison.

Nous achetons et vendons uniquement les meilleurs **produits**.
Malheureusement, **la qualité de nos marchandises se dégrade constamment à l'approche de leur date de péremption**.

Un système a été mis en place pour **mettre à jour notre inventaire.**
Il a été développé par Leeroy, une personne pleine de bon sens qui est parti pour de nouvelles aventures.

Votre mission est d'**ajouter une nouvelle fonctionnalité** à notre système pour que nous puissions commencer à vendre **un nouveau type de produit**.

Mais d'abord, laissez-moi vous présenter notre système :

- Tous les éléments ont une valeur `sellIn` qui désigne le nombre de jours restant pour vendre l'article.
- Tous les articles ont une valeur `quality` qui dénote combien l'article est précieux.
- A la fin de chaque journée, notre système diminue ces deux valeurs pour chaque produit.

Plutôt simple, non ?

Nous avons récemment signé un partenariat avec un fournisseur de produit invoqué ("Conjured").
Cela nécessite une **mise à jour** de notre système :

- **les éléments "Conjured" voient leur qualité se dégrader de deux fois plus vite que les objets normaux.**

Vous pouvez faire les changements que vous voulez à la méthode `updateQuality` et ajouter autant de code que vous voulez, tant que tout fonctionne correctement.
Cependant, nous devons vous prévenir, ne devez modifier en aucun cas la classe `Item` ou ses propriétés car cette classe appartient au gobelin de l'étage et il rentrera dans une rage instantanée et vous tuera sans délai : il ne croit pas dans le partage du code.
(Vous pouvez ajouter une méthode `updateQuality` et des propriétés statiques dans la classe `Item` si vous voulez, nous vous couvrirons)
