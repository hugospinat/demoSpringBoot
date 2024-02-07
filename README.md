# Numbering Generator Service

## Description

Le but du projet est de créer une api afin de pouvoir créer des génerateurs d'identifiant.
Une fois le génerateur crée, celui-ci ci necesite uniquement en entrant l'objet spécifié à sa création pour générer l'identifiant.

## Table of Contents

- [Installation](#installation)
- [Usage](#usage)
- [Explication](#Explicattion)
- [Amelioration](#Amelioration)


## Installation

Il est nécessaire d'avoir installer Java et maven, ainsi que de les avoir mis dans le PATH. Pour lancer le serveur il suffit d'aller à la racine du projet et d'entrer dans un terminal "mvn spring-boot:run"

## Usage

Une fois le serveur lancé, installer https://github.com/hugospinat/demoAngular pour le front.

## Explication du code

Librairie utilise : 
- spring boot 
- junit pour les tests ainsi que mockito
- hsql pour avoir une BD non persistante mais facile à changer pour une avec persitance.

## Amelioration

Je n'ai que réaliser un seul test pour le moment donc en réaliser plus.
Le code n'est quasi pas commenter pour le moment.
La classe NumberingConfiguration ne sauvgarde aucun Numbering dans la BD.