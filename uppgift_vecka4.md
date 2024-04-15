# **XML-till-JSON: En Praktisk Guide för Datahantering med Java och Git**

## **Del 1: Hantera Spelardata med Avancerad XML-parsing (3 timmar)**

### **1. Förståelse och Refaktorisering av XML-parsering**
- **Uppgift:** Ni får tillgång till [denna Casino repository](https://github.com/feldob/Casino) med ett projekt som inkluderar en befintlig XML-parser, `PlayerXMLImporter`, som använder Java DOM-verktyg för att läsa `players.xml`. Klona projektet och importera i din IDE. Testa att parsern faktiskt fungerar och granska och förstå hur. Vilka frågor ställer du dig när ni går igenom koden? Diskutera i grupp hur lättsamt ni tycker att det är att förstå sig på koden och varför.
- **Syfte:** Förstå grundläggande XML-parsing med DOM i Java och identifiera utmaningarna med lågnivå XML-parsing.

### **2. Implementera en Förbättrad XML-parser med jcabi-xml**
- **Uppgift:** Använd jcabi-xml biblioteket för att skapa en ny klass, `JcabiPlayerXMLImporter`, för att parse `players.xml`. Mål är att förenkla koden jämfört med `PlayerXMLImporter`  då den erbjuder ett mer intuitiv gränssnitt - eller Application User Interface (API) som det också kallas. Beroendet är redan fixat i pom filen. Ni kan med fördel ta hjälp av ChatGPT. Testa er parser för att säkerställa att den korrekt importerar spelardata.
- **Syfte:** Lära sig använda ett tredjepartsbibliotek för XML-parsing. Fördjupa förståelsen för dependency management och verktyg för att förenkla XML-parsing.

### **3. Utmaning: Hantering av Enkla Namnfält**
- **Uppgift:** Fundera över hur ni skulle modifiera er `Player`-klass och `JcabiPlayerXMLImporter` för att hantera en XML-struktur där spelare endast har ett `<name>`-element istället för separata `<FirstName>` och `<LastName>`. Skissa på en lösning som bryter ner `name` i för- och efternamn (krävs det Sträng hantering - vilka kommandon isf.?).
- **Syfte:** Utveckla förmågan att anpassa datamodeller och parsing-logik baserat på ändrade datatyper. Öva problemlösningsförmåga.

## **Del 2: Dataexport och Versionshantering med Git (2 timmar)**

### **1. JSON-Export med Gson**
- **Uppgift:** Lägg till ett Gson-dependency i ert projekt. Implementera sedan en klass, `GsonPlayerJSONExporter`, för att konvertera listan av spelare till en pretty-printed JSON-sträng och spara den till en fil. Använd Maven Central för att hitta och lägga till Gson-dependency:n.
- **Syfte:** Introducera JSON som ett format för datadelning och export. Förstå hur externa bibliotek kan läggas till och användas i ett Java-projekt.

### **2. Säkerhetsaspekter och Versionshantering**
- **Uppgift:** Reflektera över säkerhetsaspekterna kring användning av tredjepartsbibliotek, särskilt i ljuset av nyliga rapporter om säkerhetsbrister (som i [denna artikel](https://arstechnica.com/security/2024/03/backdoor-found-in-widely-used-linux-utility-breaks-encrypted-ssh-connections/)). Diskutera i grupp hur sådana problem kan hanteras och vilka rutiner som bör finnas på plats. 
- **Syfte:** Höja medvetenheten om säkerhetsrisker i mjukvaruutvecklingsprocessen och vikten av att hålla beroenden uppdaterade.

### **3. Delning av Projekt på GitHub**
- **Uppgift:** Skapa en egen repository på GitHub och konfigurera er lokal repository att peka på den nya så att de kommer i sync med varandra. Försök att pusha till den ursprungliga repositoryn ni klonade från och utforska varför det inte fungerar. Reflektera över användningen av `git remote` och `git push`.
- **Syfte:** Praktisk erfarenhet av att dela kod och hantera versionskontroll med Git. Förståelse för centraliserad koddelning och problem som kan uppstå med rättigheter.

**Anmärkning:** Arbetet i par uppmuntras för att främja samarbete och kunskapsutbyte. Dela upp arbetsbördan så att båda deltagarna får praktisk erfarenhet av både kodning och versionshantering.
