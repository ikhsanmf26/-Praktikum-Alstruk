const micButton = document.getElementById("micButton");
const statusText = document.getElementById("status");
const voiceText = document.getElementById("voiceText");
const calculationText = document.getElementById("calculation");
const resultText = document.getElementById("result");


// =====================================================
// CEK DUKUNGAN SPEECH RECOGNITION
// =====================================================

const SpeechRecognition =
    window.SpeechRecognition ||
    window.webkitSpeechRecognition;

if (!SpeechRecognition) {

    statusText.textContent =
        "Browser ini belum mendukung perintah suara.";

} else {

    const recognition = new SpeechRecognition();

    recognition.lang = "id-ID";

    recognition.continuous = false;

    recognition.interimResults = false;


    // =================================================
    // TOMBOL MICROPHONE
    // =================================================

    micButton.addEventListener("click", () => {

        try {

            recognition.start();

            micButton.classList.add("listening");

            statusText.textContent =
                "🎙️ Mendengarkan...";

        } catch (error) {

            console.log(error);

        }

    });


    // =================================================
    // HASIL SUARA
    // =================================================

    recognition.onresult = (event) => {

        const text =
            event.results[0][0].transcript
                .toLowerCase()
                .trim();

        voiceText.textContent = text;

        const hasil =
            hitungOperasi(text);

        if (hasil === null) {

            calculationText.textContent = "-";

            resultText.textContent = "?";

            statusText.textContent =
                "Saya belum memahami perintah tersebut.";

            bicara(
                "Maaf, saya belum memahami perhitungannya."
            );

            return;
        }


        // Tampilkan operasi

        calculationText.textContent =
            hasil.operasi;


        // Tampilkan hasil

        resultText.textContent =
            formatAngka(hasil.nilai);


        // Status

        statusText.textContent =
            "Perhitungan selesai";


        // Bacakan hasil

        bicara(
            "Hasilnya " +
            sebutAngka(hasil.nilai)
        );

    };


    // =================================================
    // SELESAI MENDENGARKAN
    // =================================================

    recognition.onend = () => {

        micButton.classList.remove("listening");

    };


    // =================================================
    // ERROR
    // =================================================

    recognition.onerror = (event) => {

        micButton.classList.remove("listening");

        console.log(event.error);

        if (event.error === "not-allowed") {

            statusText.textContent =
                "Izinkan akses mikrofon pada browser.";

        } else if (event.error === "no-speech") {

            statusText.textContent =
                "Tidak ada suara yang terdeteksi.";

        } else {

            statusText.textContent =
                "Terjadi kesalahan. Silakan coba lagi.";

        }

    };

}


// =====================================================
// FUNGSI UTAMA PERHITUNGAN
// =====================================================

function hitungOperasi(teks) {

    teks = normalisasi(teks);


    // -----------------------------------------------
    // AMBIL OPERASI
    // -----------------------------------------------

    let operator = null;


    if (
        teks.includes("ditambah") ||
        teks.includes("tambah") ||
        teks.includes("plus")
    ) {

        operator = "+";

    }

    else if (
        teks.includes("dikurangi") ||
        teks.includes("kurang") ||
        teks.includes("minus")
    ) {

        operator = "-";

    }

    else if (
        teks.includes("dikali") ||
        teks.includes("kali")
    ) {

        operator = "*";

    }

    else if (
        teks.includes("dibagi") ||
        teks.includes("bagi")
    ) {

        operator = "/";

    }


    if (!operator) {

        return null;

    }


    // -----------------------------------------------
    // PISAHKAN TEKS BERDASARKAN OPERATOR
    // -----------------------------------------------

    let bagian;

    if (operator === "+") {

        bagian =
            teks.split(/ditambah|tambah|plus/);

    }

    else if (operator === "-") {

        bagian =
            teks.split(/dikurangi|kurang|minus/);

    }

    else if (operator === "*") {

        bagian =
            teks.split(/dikali|kali/);

    }

    else {

        bagian =
            teks.split(/dibagi|bagi/);

    }


    if (bagian.length < 2) {

        return null;

    }


    const angka1 =
        bacaAngka(bagian[0].trim());

    const angka2 =
        bacaAngka(bagian[1].trim());


    if (
        angka1 === null ||
        angka2 === null
    ) {

        return null;

    }


    // -----------------------------------------------
    // HITUNG
    // -----------------------------------------------

    let hasil;


    switch (operator) {

        case "+":

            hasil = angka1 + angka2;

            break;


        case "-":

            hasil = angka1 - angka2;

            break;


        case "*":

            hasil = angka1 * angka2;

            break;


        case "/":

            if (angka2 === 0) {

                statusText.textContent =
                    "Tidak bisa membagi dengan nol.";

                bicara(
                    "Tidak bisa membagi dengan nol."
                );

                return null;
            }

            hasil = angka1 / angka2;

            break;

    }


    return {

        angka1: angka1,

        angka2: angka2,

        operator: operator,

        nilai: hasil,

        operasi:
            `${formatAngka(angka1)} ${operator} ${formatAngka(angka2)}`

    };

}


// =====================================================
// BACA ANGKA
// =====================================================

function bacaAngka(teks) {

    teks = teks.trim();


    // Jika angka biasa
    if (/^-?\d+(?:[.,]\d+)?$/.test(teks)) {

        return parseFloat(
            teks.replace(",", ".")
        );

    }


    // Ubah angka kata menjadi angka
    return kataAngka(teks);

}


// =====================================================
// KONVERSI ANGKA KATA
// =====================================================

function kataAngka(teks) {

    teks = teks
        .replace(/koma/g, " koma ")
        .replace(/\s+/g, " ")
        .trim();


    const satuan = {

        "nol": 0,
        "satu": 1,
        "dua": 2,
        "tiga": 3,
        "empat": 4,
        "lima": 5,
        "enam": 6,
        "tujuh": 7,
        "delapan": 8,
        "sembilan": 9,

        "sepuluh": 10,
        "sebelas": 11

    };


    // -----------------------------------------------
    // ANGKA 0 - 11
    // -----------------------------------------------

    if (satuan[teks] !== undefined) {

        return satuan[teks];

    }


    // -----------------------------------------------
    // BELAS
    // -----------------------------------------------

    if (teks.includes(" belas")) {

        const kata =
            teks.replace(" belas", "").trim();

        if (satuan[kata] !== undefined) {

            return satuan[kata] + 10;

        }

    }


    // -----------------------------------------------
    // PULUH
    // -----------------------------------------------

    if (teks.includes(" puluh")) {

        const bagian =
            teks.split(" puluh");

        const depan =
            satuan[bagian[0].trim()];

        if (depan !== undefined) {

            let hasil =
                depan * 10;

            const sisa =
                bagian[1].trim();

            if (sisa !== "") {

                if (satuan[sisa] !== undefined) {

                    hasil += satuan[sisa];

                }

            }

            return hasil;

        }

    }


    // -----------------------------------------------
    // RATUS
    // -----------------------------------------------

    if (teks.includes(" ratus")) {

        const bagian =
            teks.split(" ratus");

        let depan =
            bagian[0].trim();

        let nilaiDepan;

        if (depan === "") {

            nilaiDepan = 1;

        } else {

            nilaiDepan =
                satuan[depan];

        }

        if (nilaiDepan !== undefined) {

            let hasil =
                nilaiDepan * 100;

            const sisa =
                bagian[1].trim();

            if (sisa !== "") {

                const nilaiSisa =
                    kataAngka(sisa);

                if (nilaiSisa !== null) {

                    hasil += nilaiSisa;

                }

            }

            return hasil;

        }

    }


    // -----------------------------------------------
    // RIBU
    // -----------------------------------------------

    if (teks.includes(" ribu")) {

        const bagian =
            teks.split(" ribu");

        let depan =
            bagian[0].trim();

        let nilaiDepan;


        if (depan === "") {

            nilaiDepan = 1;

        } else {

            nilaiDepan =
                kataAngka(depan);

        }


        if (nilaiDepan !== null) {

            let hasil =
                nilaiDepan * 1000;

            const sisa =
                bagian[1].trim();

            if (sisa !== "") {

                const nilaiSisa =
                    kataAngka(sisa);

                if (nilaiSisa !== null) {

                    hasil += nilaiSisa;

                }

            }

            return hasil;

        }

    }


    return null;

}


// =====================================================
// NORMALISASI
// =====================================================

function normalisasi(teks) {

    return teks
        .toLowerCase()
        .replace(/[.,]/g, "")
        .replace(/\s+/g, " ")
        .trim();

}


// =====================================================
// FORMAT ANGKA
// =====================================================

function formatAngka(angka) {

    return angka.toLocaleString(
        "id-ID",
        {
            maximumFractionDigits: 10
        }
    );

}


// =====================================================
// TEXT TO SPEECH
// =====================================================

function bicara(teks) {

    if (!("speechSynthesis" in window)) {

        return;

    }


    window.speechSynthesis.cancel();


    const suara =
        new SpeechSynthesisUtterance(teks);

    suara.lang = "id-ID";

    suara.rate = 0.95;

    suara.pitch = 1;


    window.speechSynthesis.speak(suara);

}


// =====================================================
// SEBUT ANGKA
// =====================================================

function sebutAngka(angka) {

    return angka
        .toLocaleString("id-ID");

}


// =====================================================
// CONTOH OPERASI
// =====================================================

const exampleButtons =
    document.querySelectorAll(".example");


exampleButtons.forEach(button => {

    button.addEventListener("click", () => {

        const teks =
            button.textContent
                .replace(/"/g, "")
                .trim();

        voiceText.textContent = teks;

        const hasil =
            hitungOperasi(teks);


        if (hasil !== null) {

            calculationText.textContent =
                hasil.operasi;

            resultText.textContent =
                formatAngka(hasil.nilai);

            statusText.textContent =
                "Contoh berhasil dihitung.";

            bicara(
                "Hasilnya " +
                sebutAngka(hasil.nilai)
            );

        }

    });

});