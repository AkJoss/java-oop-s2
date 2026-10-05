# 🎵 Polymorphic Music

Console OOP demo: inheritance and polymorphism with music genres (K-pop, Pop, Rock, J-pop), plus a playlist average via streams.

**Author:** José Alberto Rocha Munguía

No interactive input — the program prints three demo levels and exits.

## Run (no Maven required)

```bash
export JAVA_HOME=$(/usr/libexec/java_home)
export PATH="$JAVA_HOME/bin:$PATH"

cd polymorphic-music/MusicInheritanceApp
mkdir -p out
javac -d out $(find src -name '*.java')
java -cp out com.josealrocmun.musicinheritanceapp.MusicInheritanceApp
```

## What you should see

1. **Basic** — direct subclass calls and status lines  
2. **Advanced** — `Music` references to concrete genres  
3. **Senior** — playlist average popularity (expect something like `1.75`)

The package also includes `Person` / `Athlete` / `Engineer` inheritance examples that are not driven by `main`.
