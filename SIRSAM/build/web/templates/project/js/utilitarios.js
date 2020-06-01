// Funciones Utilitarias usadas en el Proyecto

function castDay(day) {
    var n = day.toString().length;
    var cast;
    if (n === 1) {
        cast = "0" + day;
    } else {
        cast = day;
    }
    return cast;
}

function castMonth(month) {
    var n = (month + 1).toString().length;
    var cast;
    if (n === 1) {
        cast = "0" + (month + 1);
    } else {
        cast = (month + 1);
    }
    return cast;
}

function convertImgToDataURLviaCanvas(url, callback, outputFormat) {
    var img = new Image();
    img.crossOrigin = 'Anonymous';
    img.onload = function () {
        var canvas = document.createElement('CANVAS');
        var ctx = canvas.getContext('2d');
        var dataURL;
        canvas.height = this.height;
        canvas.width = this.width;
        ctx.drawImage(this, 0, 0);
        dataURL = canvas.toDataURL(outputFormat);
        callback(dataURL);
        canvas = null;
    };
    img.src = url;
}

function downloadCanvas(canvasId, filename, tipoImg) {
    html2canvas(document.querySelector(canvasId)).then(canvas => {
        var link = document.createElement('a');
        if (tipoImg === "png") {
            link.href = canvas.toDataURL("image/png");
        }
        if (tipoImg === "jpg") {
            link.href = canvas.toDataURL("image/jpeg");
        }
        link.download = filename;
        // Chequeando para browsers más viejos
        if (document.createEvent) {
            var event = document.createEvent('MouseEvents');
            // Simulando clic para descargar
            event.initMouseEvent("click", true, true, window, 0,
                    0, 0, 0, 0,
                    false, false, false, false,
                    0, null);
            link.dispatchEvent(event);
        } else {
            // Simulando clic para descargar
            link.click();
        }
    });
}

function formatNumero(numero) {
    if (numero === 0) {
        return 0.00;
    } else {
        var formateado = format("#,###,###,##0.00", numero);
        return formateado;
    }
}

function formatNumeroNoComa(numero) {
    if (numero === 0) {
        return 0.00;
    } else {
        var formateado = format("###0.00", numero);
        return formateado;
    }
}

function formatNumeroDecimal(numero) {
    if (numero === 0) {
        return 0.00;
    } else {
        var formateado = format("#,###,###,##0.00", numero);
        return formateado;
    }
}

function formatNumeroEntero(numero) {
    if (numero === 0) {
        return 0;
    } else {
        var formateado = format("#,###,###,##0", numero);
        return formateado.replace(/(\d)(?=(\d\d\d)+(?!\d))/g, "$1,");
    }
}

function formatNumeroEnteroNoComa(numero) {
    if (numero === 0) {
        return 0;
    } else {
        var formateado = format("###0", numero);
        return formateado;
    }
}

function soloNumero(event) {
    var code = event.charCode;
    if (code >= 48 && code <= 57 || code === 0) {
        return true;
    } else {
        return false;
    }
}

function soloNumeroEnter(event) {
    var code = event.charCode;
    if (code >= 48 && code <= 57 || code === 13 || code === 0) {
        return true;
    } else {
        return false;
    }
}

function soloNumDecimal(event, value) {
    var code = event.charCode;
    var pos = event.target.selectionStart;
    if (code >= 48 && code <= 57 || code === 46 || code === 0) {
        if (code === 46) {
            if (value.indexOf(".") !== -1) {
                return false;
            } else {
                return true;
            }
        } else {
            if (value.indexOf(".") !== -1) {
                var size0 = value.split(".")[0].length;
                var size1 = value.split(".")[1].length;
                if (size1 >= 0 && size1 <= 1) {
                    return true;
                } else {
                    if (pos <= size0) {
                        return true;
                    } else {
                        return false;
                    }
                }
            } else {
                return true;
            }
        }
    } else {
        return false;
    }
}

function soloNumCoordenada(event, value) {
    var code = event.charCode;
    var pos = event.target.selectionStart;
    //alert(code + " || posicion = " + pos);
    if (code >= 48 && code <= 57 || code === 45 || code === 46 || code === 0) {
        if (code === 45) {
            if (pos === 0) {
                if (value.indexOf("-") !== -1) {
                    return false;
                } else {
                    return true;
                }
            } else {
                return false;
            }
        } else {
            if (code === 46) {
                if (value.indexOf("-") !== -1) {
                    if (pos >= 0 && pos <= 1) {
                        return false;
                    } else {
                        if (value.indexOf(".") !== -1) {
                            return false;
                        } else {
                            return true;
                        }
                    }
                } else if (value.indexOf(".") !== -1) {
                    return false;
                } else {
                    if (pos === 0) {
                        return false;
                    } else {
                        return true;
                    }
                }
            } else {
                if (value.indexOf("-") !== -1) {
                    if (pos === 0) {
                        return false;
                    } else {
                        return true;
                    }
                } else {
                    return true;
                }
            }
        }
    } else {
        return false;
    }
}

function arrayABC_excel(i) {
    var array = [
        'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z',
        'AA', 'AB', 'AC', 'AD', 'AE', 'AF', 'AG', 'AH', 'AI', 'AJ', 'AK', 'AL', 'AM', 'AN', 'AO', 'AP', 'AQ', 'AR', 'AS', 'AT', 'AU', 'AV', 'AW', 'AX', 'AY', 'AZ',
        'BA', 'BB', 'BC', 'BD', 'BE', 'BF', 'BG', 'BH', 'BI', 'BJ', 'BK', 'BL', 'BM', 'BN', 'BO', 'BP', 'BQ', 'BR', 'BS', 'BT', 'BU', 'BV', 'BW', 'BX', 'BY', 'BZ',
        'CA', 'CB', 'CC', 'CD', 'CE', 'CF', 'CG', 'CH', 'CI', 'CJ', 'CK', 'CL', 'CM', 'CN', 'CO', 'CP', 'CQ', 'CR', 'CS', 'CT', 'CU', 'CV', 'CW', 'CX', 'CY', 'CZ'
    ];
    return array[i];
}

function castDateString(date) {
    var dateS = date.split("-");
    return dateS[2] + '/' + dateS[1] + '/' + dateS[0];
}

function castDateString1(date) {
    var dateS = date.split("/");
    return dateS[2] + '-' + dateS[1] + '-' + dateS[0];
}

