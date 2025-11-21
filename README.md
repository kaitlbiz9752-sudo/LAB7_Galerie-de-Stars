# StarsGallery – README

## Introduction
StarsGallery est une application Android développée en Java permettant :
- d'afficher une liste d'acteurs/actrices,
- de rechercher dynamiquement une star grâce à une SearchView,
- de modifier la note d’une star via un popup personnalisé,
- d’afficher un SplashScreen animé au lancement,
- de partager l’application via Android ShareCompat.

L’architecture est basée sur MVC :  
**Model (beans)** – **DAO** – **Service** – **Adapter** – **UI (Activities)**.

---

## Étape 1 — Structure du projet

Créer un projet Android nommé **StarsGallery** puis ajouter les packages suivants :

```
beans/
dao/
service/
adapter/
ui/
```

Créer les classes :
- `Star` (beans)
- `IDao` (dao)
- `StarService` (service)
- `StarAdapter` (adapter)
- `SplashActivity` et `ListActivity` (ui)

Ajouter une image `star.png` dans `res/drawable`.

---

## Étape 2 — Splash Screen animé

Créer `activity_splash.xml` avec un `ImageView`.  
Dans `SplashActivity.java`, ajouter des animations :

- rotation()
- scaleX(), scaleY()
- translationYBy()
- alpha()

Après 5 secondes → redirection vers `ListActivity`.

Le manifeste doit déclarer SplashActivity comme activité principale.

---

## Étape 3 — Modèle Star

Classe `Star` contenant :
- id auto-incrémenté
- name
- img (URL)
- rating

---

## Étape 4 — Interface IDao

Interface CRUD générique :

```
boolean create(T o);
boolean update(T o);
boolean delete(T o);
T findById(int id);
List<T> findAll();
```

---

## Étape 5 — Service (StarService)

Implémente `IDao<Star>`.  
Utilise le pattern Singleton.  
La méthode `seed()` initialise une liste de stars avec nom, URL image et rating.

---

## Étape 6 — Adapter + RecyclerView

Créer `star_item.xml` avec :
- CircleImageView
- TextView
- RatingBar

Créer `StarAdapter.java` :
- bind image avec Glide
- afficher nom et rating
- gère la liste filtrée plus tard

Dans `ListActivity` :
- configurer RecyclerView + LinearLayoutManager
- définir l'adapter

---

## Étape 7 — SearchView & Filtrage

Créer `menu.xml` avec :
- icon Search
- `SearchView` intégré

Dans `ListActivity` :
- redéfinir `onCreateOptionsMenu()`
- utiliser `searchView.setOnQueryTextListener(...)`

Dans `StarAdapter` :
- implémenter `Filterable`
- créer la classe interne `NewFilter`

Filtrage dynamique grâce à :
```
starAdapter.getFilter().filter(newText);
```

---

## Étape 8 — Menu Share

Ajouter dans `menu.xml` :
```
<item
    android:id="@+id/share"
    android:title="Partager"
    android:icon="@android:drawable/ic_menu_share"
    app:showAsAction="always" />
```

Dans `ListActivity` :
```
ShareCompat.IntentBuilder.from(this)
    .setType("text/plain")
    .setText("Stars")
    .startChooser();
```

---

## Étape 9 — Popup d’édition de note

Créer `star_edit_item.xml` :
- CircleImageView
- RatingBar

Dans `StarAdapter` → dans `onCreateViewHolder()` :
- détecter clic sur item
- ouvrir un AlertDialog personnalisé
- modifier rating
- appeler `notifyItemChanged(position)`

---

## Étape 10 — Permissions

Dans le Manifest, ajouter :

```
<uses-permission android:name="android.permission.INTERNET" />
```

Glide nécessite Internet pour charger les images.

---

## Conclusion

Ce TP couvre :
- RecyclerView
- SearchView + filtrage
- Glide (chargement d’images)
- Dialog personnalisé
- SplashScreen animé
- ShareCompat
- MVC Android

Le projet est complet et opérationnel.



## Démonstration Vidéo :





https://github.com/user-attachments/assets/4e083a2e-c8fc-4017-91ad-517aa690708e

