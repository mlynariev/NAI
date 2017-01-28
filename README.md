# NAI
OPEN // lista węzłów do oszacowania
CLOSED // list węzłów już oszacowanych
dodaj początkowy węzeł do OPEN

loop
    current = node w OPEN z najniższym kosztem.
    usuń current z OPEN
    dodaj current do CLOSED

    if current jest punktem końcowym //ścieżka została znaleziona
        return

    foreach sasiąda current node
        if sasiąd nie jest możliwy do przejścia LUB sasiąd jest w CLOSED
            przeskocz do następnego sąsiada

        if nowa ścieżka do sąsiada jest krótsza lub sąsiad nie jest w OPEN
            ustaw fCost sąsiada
            ustaw rodzica sąsiada to current 
            if sasiąd nie jest w OPEN
                dodaj sąsiada do OPEN
