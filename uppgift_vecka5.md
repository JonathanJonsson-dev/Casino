# **Enhetstestning och TDD med JUnit i Java**

## **Del 1: Förberedelse och Implementering av Enhetstester**

- **Nytt Krav:** Ett nytt krav har kommit in - Casino tjänsten ska tillåta användare att skicka pengar emellan varandra. Ta hem de senaste ändringar i kodbasen och titta specifikt i `pom.xml` och `src/main/test`. Vilka skillnader kan du se?

- **Syfte:** Förstå vad som krävs för att sätta upp test i projekt.

Nu är du redo att skapa egna enhetstester enligt TDD. Den förväntade metoden är redan hänvisat till i `PlayerServiceTest`. Kan du implementera ett första enhetstest som testar ett väntat beteende - tex att den totala summan av tillgångerna på båda spelare är exakt samma innan som efter transaktionen. För det behöver du lära dig om hur assertions fungerar i JUnit. ChatGPT kan nog hjälpa dig med hur det kan uttryckas i korrekt JUnit syntax. Det finns många sätt att skriva assertions och väldigt många test metoder i `org.junit.Test` klassen - undersök vad som finns.

## **Del 2: Fördjupning i Enhetstestning och TDD**

- **TDD processen:** Försök att följa de 3 stegen i TDD modellen för metoden och för ett beteende (se exempel ovan). Du borde få testerna att först faila (Run code as JUnit test -> röd). Sedan, implementera metoden transfer i `PlayerService` på enklaste sättet för att möta kravet från testet. kör testet igen, så det blir korret  (Run code as JUnit test -> grönt). Kolla nu om du kan förenklar koden något eller komma på ett nästa testfall/beteende som är väntat men som koden inte säkerställer. Till exempel att göra negative överföringar eller transfererar mer saldo än den första spelaren besitter. Ska enhetstester efter samma mönster för varje beteende och följ TDD (minst stegen 1 och 2 - 3 kan va lite svårt att behöva/uppnå för rätt så enkel kod). Man kan även uttrycka så kallade negativa tester som gör att testet blir fel och det är det som är det förväntade resultatet. Släng en Exception isf (vi pratar mer om exceptions nästa vecka). Hur testar man för exceptions med JUnit?

- **Syfte:** Testa processen att få metodernas design och implementationen att växa steg för steg för varje beteende som du kräver genom dina tester.

## **Del 3: Hur bra blev det?**

Kolla med dina kursare om ni fångat samma problembeteenden. Man brukar vilja ha några tester som beskriver önskade scenarion, men vanligtvist flera som tester gränsvärden som inte fungerar. Ni bode identifiera minst 5 assertions. Enligt god testvana implementerar man en assertion per test metod (som har annotationen @Test).

Ni kan köra alla tester lokalt genom maven med goal `test` som kör alla tester som ligger under test paketet och som har en `@Test` annotation.

När alla tester kör igenom och du får meddelandet "BUILD SUCCESSFUL" kan du uppdatera din remote repo med dina ändringar. Bra jobbat!

## **Del 4: Pass by reference**
Att förstå hur objekt behandlas när de går mellan metodanrop är viktigt för att verkligen förstå hur Java fungerar i djupet. Fundera på 2-3 testfall som kan validera att Java faktiskt använder Pass by reference och inte pass by value för objekt. Fundera vad du skulle förvänta dig i båda fall och skriv tester som utgår ifrån att Java implementerar pass by reference korrekt. Det spelar ingen roll vilka klasser och metoder du använder, men bra om du håller klasserna enkla. Några tips:
- När man returnerar från en metod får man referens till objekt tillbaka som kan sedan jämföras med andra objekt, tex för likhet i deras fält.
- Metoden som testas måste ha minst en objekt parameter.
- Fundera på : Vad är skillnaden i objekt som returneras av en metod om det är pass by value eller pass by reference?