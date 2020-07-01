package com.codebrewers.onlinebookstore.utils.templet;

import com.codebrewers.onlinebookstore.model.BookCartDetails;
import com.codebrewers.onlinebookstore.model.CartDetails;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PlacedOrder {

    public String getHeader(CartDetails cart, Integer orderID, Double totalPrice, List<BookCartDetails> bookDetails, Double discountPrice) {
        return "<!DOCTYPE html PUBLIC '-//W3C//DTD XHTML 1.0 Transitional//EN'\n" +
                "        'http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd'>\n" +
                "<html xmlns:th='http://www.thymeleaf.org' xmlns='http://www.w3.org/1999/xhtml'>\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <meta content=\"width=device-width, initial-scale=1\" name=\"viewport\">\n" +
                "    <meta name=\"x-apple-disable-message-reformatting\">\n" +
                "    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n" +
                "    <meta content=\"telephone=no\" name=\"format-detection\">\n" +
                "    <title></title>\n" +
                "    <!--[if (mso 16)]>\n" +
                "    <style type=\"text/css\">\n" +
                "    a {text-decoration: none;}\n" +
                "    </style>\n" +
                "    <![endif]-->\n" +
                "    <!--[if gte mso 9]><style>sup { font-size: 100% !important; }</style><![endif]-->\n" +
                "    <!--[if gte mso 9]>\n" +
                "<xml>\n" +
                "    <o:OfficeDocumentSettings>\n" +
                "    <o:AllowPNG></o:AllowPNG>\n" +
                "    <o:PixelsPerInch>96</o:PixelsPerInch>\n" +
                "    </o:OfficeDocumentSettings>\n" +
                "</xml>\n" +
                "<![endif]-->\n" +
                "</head>\n" +
                "\n" +
                "<body>\n" +
                "    <div class=\"es-wrapper-color\">\n" +
                "        <!--[if gte mso 9]>\n" +
                "\t\t\t<v:background xmlns:v=\"urn:schemas-microsoft-com:vml\" fill=\"t\">\n" +
                "\t\t\t\t<v:fill type=\"tile\" color=\"#555555\"></v:fill>\n" +
                "\t\t\t</v:background>\n" +
                "\t\t<![endif]-->\n" +
                "        <table class=\"es-wrapper\" width=\"100%\" cellspacing=\"0\" cellpadding=\"0\">\n" +
                "            <tbody>\n" +
                "                <tr>\n" +
                "                    <td class=\"esd-email-paddings\" valign=\"top\">\n" +
                "                        <table cellpadding=\"0\" cellspacing=\"0\" class=\"es-content esd-header-popover\" align=\"center\">\n" +
                "                            <tbody>\n" +
                "                                <tr>\n" +
                "                                    <td class=\"esd-stripe\" align=\"center\" esd-custom-block-id=\"88701\">\n" +
                "                                        <table class=\"es-content-body\" style=\"background-color: transparent;\" width=\"600\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\">\n" +
                "                                            <tbody>\n" +
                "                                                <tr>\n" +
                "                                                    <td class=\"esd-structure es-p5b es-p10r es-p10l\" esd-general-paddings-checked=\"false\" align=\"left\">\n" +
                "                                                        <!--[if mso]></td></tr></table><![endif]-->\n" +
                "                                                    </td>\n" +
                "                                                </tr>\n" +
                "                                            </tbody>\n" +
                "                                        </table>\n" +
                "                                    </td>\n" +
                "                                </tr>\n" +
                "                            </tbody>\n" +
                "                        </table>\n" +
                "                        <table class=\"es-content\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\">\n" +
                "                            <tbody>\n" +
                "                                <tr>\n" +
                "                                    <td class=\"esd-stripe\" align=\"center\">\n" +
                "                                        <table class=\"es-content-body\" width=\"600\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\">\n" +
                "                                            <tbody>\n" +
                "                                                <tr>\n" +
                "                                                    <td class=\"esd-structure es-p20t es-p20b es-p20r es-p20l\" esd-general-paddings-checked=\"false\" style=\"background-color: #ba3d3d;\" bgcolor=\"#ba3d3d\" align=\"left\">\n" +
                "                                                        <table width=\"100%\" cellspacing=\"0\" cellpadding=\"0\">\n" +
                "                                                            <tbody>\n" +
                "                                                                <tr>\n" +
                "                                                                    <td class=\"esd-container-frame\" width=\"560\" valign=\"top\" align=\"center\">\n" +
                "                                                                        <table width=\"100%\" cellspacing=\"0\" cellpadding=\"0\">\n" +
                "                                                                            <tbody>\n" +
                "                                                                                <tr>\n" +
                "                                                                                    <td class=\"esd-block-text es-p15t es-p15b\" align=\"center\">\n" +
                "                                                                                        <div class=\"esd-text\">\n" +
                "                                                                                            <h2 style=\"color: #ffffff;\"><span style=\"font-size:30px;\"><strong>Your order is confirmed. </strong></span><br></h2>\n" +
                "                                                                                        </div>\n" +
                "                                                                                    </td>\n" +
                "                                                                                </tr>\n" +
                "                                                                                <tr>\n" +
                "                                                                                    <td class=\"esd-block-text es-p10l\" align=\"center\">\n" +
                "                                                                                        <p style=\"color: #ffffff;\">Hi  " + cart.getUserDetails().fullName + ", Congratulations! Your order for the books is Successfully Placed.<br> Save this orderId: #" + orderID + " for further communication.<br></p>\n" +
                "                                                                                    </td>\n" +
                "                                                                                </tr>\n" +
                "                                                                            </tbody>\n" +
                "                                                                        </table>\n" +
                "                                                                    </td>\n" +
                "                                                                </tr>\n" +
                "                                                            </tbody>\n" +
                "                                                        </table>\n" +
                "                                                    </td>\n" +
                "                                                </tr>\n" +
                "                                                <tr>\n" +
                "                                                    <td class=\"esd-structure es-p15t es-p10b es-p10r es-p10l\" style=\"background-color: #f8f8f8;\" esd-general-paddings-checked=\"false\" bgcolor=\"#f8f8f8\" align=\"left\">\n" +
                "                                                        <table width=\"100%\" cellspacing=\"0\" cellpadding=\"0\">\n" +
                "                                                            <tbody>\n" +
                "                                                                <tr>\n" +
                "                                                                    <td class=\"esd-container-frame\" width=\"580\" valign=\"top\" align=\"center\">\n" +
                "                                                                        <table width=\"100%\" cellspacing=\"0\" cellpadding=\"0\">\n" +
                "                                                                            <tbody>\n" +
                "                                                                                <tr>\n" +
                "                                                                                    <td class=\"esd-block-text\" align=\"center\">\n" +
                "                                                                                        <h2 style=\"color: #191919;\">Items ordered<br></h2>\n" +
                "                                                                                    </td>\n" +
                "                                                                                </tr>\n" +
                "                                                                            </tbody>\n" +
                "                                                                        </table>\n" +
                "                                                                    </td>\n" +
                "                                                                </tr>\n" +
                "                                                            </tbody>\n" +
                "                                                        </table>\n" +
                "                                                    </td>\n" +
                "                                                </tr>\n" +
                generateTable(bookDetails) +
                "                                                                                <tr>\n" +
                "                                                                                    <td class=\"esd-block-text es-p15b\" align=\"center\">\n" +
                "                                                                                        <table class=\"cke_show_border\" width=\"240\" height=\"101\" cellspacing=\"1\" cellpadding=\"1\" border=\"0\">\n" +
                "                                                                                            <tbody>\n" +

                "                                                                                                <tr>\n" +
                "                                                                                                    <td><span style=\"font-size: 15px; line-height: 200%;\">Sub Total:</span></td>\n" +
                "                                                                                                    <td style=\"text-align: right;\"><span style=\"font-size: 15px; line-height: 200%;\"> RS. " + totalPrice + "</span></td>\n" +
                "                                                                                                </tr>\n" +

                "                                                                                                <tr>\n" +
                "                                                                                                    <td><span style=\"font-size: 15px; line-height: 170%;\">Discount Price:</span></td>\n" +
                "                                                                                                    <td style=\"text-align: right;\"><span style=\"font-size: 15px; line-height: 170%; margin-left: -5%\">RS. -" + discountPrice + "</span></td>\n" +
                "                                                                                                </tr>\n" +

                "                                                                                                <hr style=\"width:180%;margin-left:0%;\"><tr>\n" +
                "                                                                                                    <td><span style=\"font-size: 18px; line-height: 180%;\"><strong>Total Price:</strong></span></td>\n" +
                "                                                                                                    <td style=\"text-align: right;\"><span style=\"font-size: 18px; line-height: 180%;\"><strong> RS. " + ((totalPrice - discountPrice) < 0 ? 0 : (totalPrice - discountPrice)) + "</strong></span></td>\n" +
                "                                                                                                </tr>\n" +
                "                                                                                            </tbody>\n" +
                "                                                                                        </table>\n" +
                "                                                                                    </td>\n" +
                "                                                                                </tr>\n" +
                "                                                                            </tbody>\n" +
                "                                                                        </table>\n" +
                "                                                                    </td>\n" +
                "                                                                </tr>\n" +
                "                                                            </tbody>\n" +
                "                                                        </table>\n" +

                "                                                       <p style=\"font-size: 14px;font-weight: normal; margin-left: 10px;  font-family:\"Tangerine\", serif;\">Thanks,<br>\n" +
                "                                                       The CB's Book Stores Team</p>\n" +

                "                                                    </td>\n" +
                "                                                </tr>\n" +
                "                                                <tr>\n" +
                "                                                </tr>\n" +
                "                                                            </tbody>\n" +
                "                                                        </table>\n" +
                "                                                    </td>\n" +
                "                                                </tr>\n" +
                "                                            </tbody>\n" +
                "                                        </table>\n" +
                "                                    </td>\n" +
                "                                </tr>\n" +
                "                            </tbody>\n" +
                "                        </table>\n" +
                "                    </td>\n" +
                "                </tr>\n" +
                "            </tbody>\n" +
                "        </table>\n" +
                "    </div>\n" +
                "</body>\n" +
                "\n" +
                "</html>";
    }

    private String generateTable(List<BookCartDetails> cartItemsList) {
        StringBuilder table = new StringBuilder();
        for (BookCartDetails cartItems : cartItemsList) {
            table.append(
                    "                                                <tr>\n" +
                            "                                                    <td class=\"esd-structure es-p25t es-p5b es-p20r es-p20l\" esd-general-paddings-checked=\"false\" style=\"background-color: #f8f8f8;\" bgcolor=\"#f8f8f8\" align=\"left\">\n" +
                            "                                                        <!--[if mso]><table width=\"560\" cellpadding=\"0\" cellspacing=\"0\"><tr><td width=\"270\" valign=\"top\"><![endif]-->\n" +
                            "                                                        <table class=\"es-left\" cellspacing=\"0\" cellpadding=\"0\" align=\"left\">\n" +
                            "                                                            <tbody>\n" +
                            "                                                                <tr>\n" +
                            "                                                                    <td class=\"es-m-p20b esd-container-frame\" width=\"270\" align=\"left\">\n" +
                            "                                                                        <table width=\"100%\" cellspacing=\"0\" cellpadding=\"0\">\n" +
                            "                                                                            <tbody>\n" +
                            "                                                                                <tr>\n" +
                            "                                                                                    <td class=\"esd-block-image\" align=\"center\" style=\"font-size:0;\"><a target=\"_blank\" href=\"https://viewstripo.email/\"><img class=\"adapt-img\" style=\"margin-bottom:5%; margin-top:5%;\" height=\"150vh\" width=\"168vh\" src=\" https://www.pinclipart.com/picdir/middle/339-3397322_closed-book-clipart-codigo-de-etica-dibujos-png.png    \" alt width=\"103\"></a></td>\n" +
                            "                                                                                </tr>\n" +
                            "                                                                            </tbody>\n" +
                            "                                                                        </table>\n" +
                            "                                                                    </td>\n" +
                            "                                                                </tr>\n" +
                            "                                                            </tbody>\n" +
                            "                                                        </table>\n" +
                            "                                                        <!--[if mso]></td><td width=\"20\"></td><td width=\"270\" valign=\"top\"><![endif]-->\n" +
                            "                                                        <table class=\"es-right\" cellspacing=\"0\" cellpadding=\"0\" align=\"right\">\n" +
                            "                                                            <tbody>\n" +
                            "                                                                <tr>\n" +
                            "                                                                    <td class=\"esd-container-frame\" width=\"270\" align=\"left\">\n" +
                            "                                                                        <table width=\"100%\" cellspacing=\"0\" cellpadding=\"0\">\n" +
                            "                                                                            <tbody>\n" +
                            "                                                                                <tr>\n" +
                            "                                                                                    <td class=\"esd-block-text\" align=\"left\">\n" +
                            "                                                                                        <p><span style=\"font-size:16px;\"><strong style=\"line-height: 150%;\">" + cartItems.getBookDetails().bookName + "</strong></span><br>" +
                            "                                                                                   <span style=\"font-size:12px;\"> by " + cartItems.getBookDetails().authorName + "</span></p>\n" +
                            "                                                                                    </td>\n" +
                            "                                                                                    <td class=\"esd-block-text es-p20t\" align=\"left\">\n" +
                            "                                                                                        <p><span style=\"font-size:15px;\"><strong style=\"line-height: 150%;\">Rs.</strong> " + cartItems.totalPrice + "</span></p>\n" +
                            "                                                                                        <p><span style=\"font-size:15px;\"><strong>Qty: </strong>" + cartItems.quantity + "</span></p>\n" +
                            "                                                                                    </td>\n" +
                            "                                                                                </tr>\n" +
                            "                                                                                <tr>\n" +
                            "                                                                                </tr>\n" +
                            "                                                                            </tbody>\n" +
                            "                                                                        </table>\n" +
                            "                                                                    </td>\n" +
                            "                                                                </tr>\n" +
                            "                                                            </tbody>\n" +
                            "                                                        </table>\n" +
                            "                                                        <!--[if mso]></td></tr></table><![endif]-->\n" +
                            "                                                    </td>\n" +
                            "                                                </tr>\n" +
                            "                                                <tr>\n" +
                            "                                                    <td class=\"esd-structure es-p10t es-p10b es-p10r es-p10l\" style=\"background-color: #f8f8f8;\" esd-general-paddings-checked=\"false\" bgcolor=\"#f8f8f8\" align=\"left\">\n" +
                            "                                                        <table width=\"100%\" cellspacing=\"0\" cellpadding=\"0\">\n" +
                            "                                                            <tbody>\n" +
                            "                                                                <tr>\n" +
                            "                                                                    <td class=\"esd-container-frame\" width=\"580\" valign=\"top\" align=\"center\">\n" +
                            "                                                                        <table width=\"100%\" cellspacing=\"0\" cellpadding=\"0\">\n" +
                            "                                                                            <tbody>\n" +
                            "                                                                                <tr>\n" +
                            "                                                                                    <td class=\"esd-block-spacer es-p20t es-p20b es-p10r es-p10l\" bgcolor=\"#f8f8f8\" align=\"center\" style=\"font-size:0\">\n" +
                            "                                                                                        <table width=\"100%\" height=\"100%\" cellspacing=\"0\" cellpadding=\"0\" border=\"0\">\n" +
                            "                                                                                            <tbody>\n" +
                            "                                                                                                <tr>\n" +
                            "                                                                                                    <td style=\"border-bottom: 0.7px solid #595757; background: rgba(0, 0, 0, 0) none repeat scroll 0% 0%; height: 0.8px; width: 100%; margin: 0px;\"></td>\n" +
                            "                                                                                                </tr>\n" +
                            "                                                                                            </tbody>\n" +
                            "                                                                                        </table>\n" +
                            "                                                                                    </td>\n" +
                            "                                                                                </tr>\n"
            );

        }
        return table.toString();
    }
}
