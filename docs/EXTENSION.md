# EXTENSION.md — דוח מבחן ההרחבה (חלק ד׳)

**שם:** ‎_אברהם אלעזרה  **ת.ז. / מספר סטודנט:** ‎_216560284

---

### 1. רשימת כל הקבצים ששיניתם או יצרתם בחלק ד׳

| קובץ | נוצר / שונה | מה בדיוק השתנה |
|------|--------------|-----------------|
|OversizedCargo.java  | נוצר | מחלקה חדשה המייצגת מטען חריג, יורשת מ-CargoUnit ומממשת את כללי התעריף והבטיחות הספציפיים לה. |
| TerminalApp.java | שונה | נוספו שורות קוד ליצירת אובייקט OversizedCargo, הוספתו למסוף באמצעות yard.receive(), והדפסת המניפסט מחדש. |

> אם `Yard.java` מופיע בטבלה — התכן שלכם אינו עומד בעקרון הפתוח/סגור.
> הסבירו מדוע נאלצתם לשנות אותו וכיצד הייתם מתקנים את התכן.

---
(הערה: Yard.java לא שונה כלל, שכן התכן פעל במדויק לפי עקרון OCP)
### 2. פלט ההרצה

הדביקו כאן את המניפסט **לפני** ו**אחרי** קליטת ה־`OversizedCargo`.

לפני:
```
=== 1. YARD MANIFEST ===
Standard[id=U-01, owner=Standard Imports, 2000.0 kg, 5 days] [volume=33.2m3]
Safety: Standard handling procedure.
Reefer[id=U-02, owner=Global Logistics, 3500.0 kg, 3 days] [volume=33.2m3] [temp=4.0C, power=5.5kW]
Safety: Maintain target temp: 4.0C
Hazmat[id=U-03, owner=Ministry of Health, 1500.0 kg, 2 days] [volume=33.2m3] [Hazard Class=3, Escort=true]
Safety: Hazard Class 3. Escort required: true
Tank[id=U-04, owner=Global Logistics, 4000.0 kg, 10 days] [Capacity=25000.0L, Fill=80.0%]
Safety: Liquid Tank Handling Protocol.
Total Daily Revenue: 2206.73

```

אחרי:
```
=== 4. PART D - OVERSIZED CARGO ===
Oversized cargo added successfully. Reprinting manifest:

Standard[id=U-01, owner=Standard Imports, 2000.0 kg, 5 days] [volume=33.2m3]
Safety: Standard handling procedure.
Reefer[id=U-02, owner=Global Logistics, 3500.0 kg, 3 days] [volume=33.2m3] [temp=4.0C, power=5.5kW]
Safety: Maintain target temp: 4.0C
Hazmat[id=U-03, owner=Ministry of Health, 1500.0 kg, 2 days] [volume=33.2m3] [Hazard Class=3, Escort=true]
Safety: Hazard Class 3. Escort required: true
Tank[id=U-04, owner=Global Logistics, 4000.0 kg, 10 days] [Capacity=25000.0L, Fill=68.0%]
Safety: Liquid Tank Handling Protocol.
Oversize[id=U-05, owner=Ministry of Health, 12000.0 kg, 1 days] [length=15.5m, crane=true]
Safety: Heavy crane required: true
Total Daily Revenue: 2316.23
```

---

### 3. שאלת ההבנה
`Yard.printManifest()` הדפיסה שורה תקינה עבור `OversizedCargo`
למרות ש־`Yard` מעולם לא שמעה על המחלקה הזו.
הסבירו במדויק **מתי** הוחלט איזה קוד ירוץ עבור השורה
`unit.handlingCategory()` — בזמן קומפילציה או בזמן ריצה — ומה בדיוק
הקומפיילר כן ידע באותו רגע.

תשובה:
ההחלטה איזה קוד ירוץ בפועל התקבלה בזמן ריצה (Dynamic Dispatch), בהתאם לטיפוס הדינמי המדויק של האובייקט שנוצר בזיכרון (במקרה זה, OversizedCargo).
בזמן הקומפילציה, הקומפיילר ידע רק שהטיפוס הסטטי של המשתנה הוא CargoUnit. 
הוא וידא שהמחלקה המופשטת CargoUnit אכן מגדירה פעולה בשם handlingCategory(), ולכן אישר את חוקיות הקריאה, מבלי לדעת איזו מחלקה ספציפית תממש אותה בפועל.